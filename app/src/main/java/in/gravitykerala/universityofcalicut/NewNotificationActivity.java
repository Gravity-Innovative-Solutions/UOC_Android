package in.gravitykerala.universityofcalicut;


import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.microsoft.windowsazure.mobileservices.MobileServiceException;
import com.microsoft.windowsazure.mobileservices.MobileServiceList;
import com.microsoft.windowsazure.mobileservices.http.NextServiceFilterCallback;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilter;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterRequest;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import java.util.List;
import java.util.concurrent.ExecutionException;

import in.gravitykerala.universityofcalicut.Models.MobileNotification;

public class NewNotificationActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    final public static String KEY_NOTIFICATION_TYPE = "NOTIFICATION_TYPE";

    final public static String NOTIFICATION_NOTIFICATION_ORDERS = "NOTIFICATION_ORDERS";
    final public static String NOTIFICATION_VC_DESK = "NOTIFICATION_VC_DESK";
    final public static String NOTIFICATION_NOTIFICATION_NEWS = "NOTIFICATION_NEWS";
    final public static String NOTIFICATION_EXAM_NOTIFICATIONS = "EXAM_NOTIFICATIONS";
    final public static String NOTIFICATION_EXAM_RESULT = "EXAM_RESULT";
    final public static String NOTIFICATION_EXAM_TIMETABLE = "EXAM_TIMETABLE";
    final public static String NOTIFICATION_DISTANCE_NOTIFICATION = "DISTANCE_NOTIFICATION";
    final public static String NOTIFICATION_DISTANCE_CONTACT_CLASS = "DISTANCE_CONTACT_CLASS";
    final public static String NOTIFICATION_DISTANCE_STUDY_MATERIAL = "DISTANCE_STUDY_MATERIAL";
    final public static String NOTIFICATION_DISTANCE_QUESTION_BANK = "DISTANCE_QUESTION_BANK";
    final public static String NOTIFICATION_COMMON = "NOTIFICATION_COMMON";
    private SwipeRefreshLayout mSwipeLayout;
    AsyncCourseLoader courseAsyncTask;
    /**
     * Mobile Service Table used to access data
     */
    private MobileServiceTable<MobileNotification> mToDoTable;

    /**
     * Adapter to sync the items list with the view
     */

    private NewNotificationItemAdapter mAdapter;

    /**
     * EditText containing the "New To Do" text
     */
    //private EditText mTextNewToDo;

    /**
     * Progress spinner to use for table operations
     */
    private ProgressBar mProgressBar;

    Button buttonRefresh;

    /**
     * Initializes the activity
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_notification);

//        mClient=NotificationActivity.mClient;
        mProgressBar = (ProgressBar) findViewById(R.id.loadingProgressBar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        buttonRefresh = (Button) findViewById(R.id.button_refresh);
        // Initialize the progress bar
//        mProgressBar.setVisibility(ProgressBar.GONE);
        mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        mSwipeLayout.setOnRefreshListener(this);
        mSwipeLayout.setColorSchemeResources(android.R.color.holo_red_light,
                android.R.color.holo_green_light, android.R.color.holo_orange_light,
                android.R.color.holo_blue_light);
        mSwipeLayout.setEnabled(true);
        try {
            // Create the Mobile Service Client instance, using the provided
            // Mobile Service URL and key

            NotificationActivity.initializeMobileService(this);
            NotificationActivity.mClient.withFilter(new ProgressFilter());

            String api = "MobileNews";
            if (getIntent().getStringExtra(KEY_NOTIFICATION_TYPE).equals(NOTIFICATION_NOTIFICATION_ORDERS)) {
               api="MobileUniversityOrders";
           }
            if (getIntent().getStringExtra(KEY_NOTIFICATION_TYPE).equals(NOTIFICATION_VC_DESK)) {
                api="MobileVcDesk";
            }
            if (getIntent().getStringExtra(KEY_NOTIFICATION_TYPE).equals(NOTIFICATION_NOTIFICATION_NEWS)) {
                api="MobileNews";
            }
            if (getIntent().getStringExtra(KEY_NOTIFICATION_TYPE).equals(NOTIFICATION_EXAM_NOTIFICATIONS)) {
                api="MobilePareekshabhavanNotification";
            }
            if (getIntent().getStringExtra(KEY_NOTIFICATION_TYPE).equals(NOTIFICATION_EXAM_RESULT)) {
                api="MobileResult";
            }
            if (getIntent().getStringExtra(KEY_NOTIFICATION_TYPE).equals(NOTIFICATION_EXAM_TIMETABLE)) {
                api="MobileTimeTable";
            }
            if (getIntent().getStringExtra(KEY_NOTIFICATION_TYPE).equals(NOTIFICATION_DISTANCE_NOTIFICATION)) {
                api="MobileDistanceEducationNotification";
            }
            if (getIntent().getStringExtra(KEY_NOTIFICATION_TYPE).equals(NOTIFICATION_DISTANCE_CONTACT_CLASS)) {
                api="MobileContactClass";
            }
            if (getIntent().getStringExtra(KEY_NOTIFICATION_TYPE).equals(NOTIFICATION_DISTANCE_STUDY_MATERIAL)) {
                api="MobileStudyMaterials";
            }
            if (getIntent().getStringExtra(KEY_NOTIFICATION_TYPE).equals(NOTIFICATION_DISTANCE_QUESTION_BANK)) {
                api="MobileQuestionBank";
            } //TODO: Add NOTIFICATION_COMMON


            // Get the Mobile Service Table instance to use
            mToDoTable = NotificationActivity.mClient.getTable(api, MobileNotification.class);

            //mTextNewToDo = (EditText) findViewById(R.id.textNewToDo);

            // Create an adapter to bind the items with the view
            mAdapter = new NewNotificationItemAdapter(this, R.layout.single_row_list_notification);
            ListView listViewToDo = (ListView) findViewById(R.id.listViewToDo);
            listViewToDo.setAdapter(mAdapter);

            // Load the items from the Mobile Service
            // refreshItemsFromTable();

            refreshCourseItems();
        } catch (Exception e) {
            e.printStackTrace();
            ///createAndShowDialog(new Exception("There was an error creating the Mobile Service. Verify the URL"), "Error");
        }
    }

    /**
     * Initializes the activity menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_notification, menu);
        return true;
    }

    /**
     * Select an option from the menu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_refresh) {
            refreshCourseItems();
        }

        return true;
    }




    /**
     * Refresh the list with the items in the Mobile Service Table
     */



    /**
     * Creates a dialog and shows it
     *
     * @param message The dialog message
     * @param title   The dialog title
     */
    private void createAndShowDialog(final String message, final String title) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(message);
        builder.setTitle(title);
        builder.create().show();
    }

    @Override
    public void onRefresh() {

        refreshCourseItems();
        mSwipeLayout.setRefreshing(true);

    }

    private void refreshCourseItems() {

        courseAsyncTask = new AsyncCourseLoader();
        courseAsyncTask.execute();


    }

    private class AsyncCourseLoader extends AsyncTask<Void, Void, List<MobileNotification>> {

        protected List<MobileNotification> doInBackground(Void... params) {
            MobileServiceList<MobileNotification> results = null;
            try {
                final List<MobileNotification> result =
                        mToDoTable.execute().get();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.clear();

                        for (MobileNotification item : result) {
                            mAdapter.add(item);
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
//                courseAsyncTask = new AsyncCourseLoader();
//                courseAsyncTask.execute();

            }
            try {
                results = mToDoTable.execute().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (MobileServiceException e) {
                e.printStackTrace();
            }
            return results;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //  mSwipeLayout.setRefreshing(true);


        }

        protected void onPostExecute(List<MobileNotification> MobileNotification) {
            super.onPostExecute(MobileNotification);
            mSwipeLayout.setRefreshing(false);

            if (MobileNotification != null && !MobileNotification.isEmpty()) //Successfull results
            {
//            DepartmentDTO dummySelector = new DepartmentDTO(); //Used for showing the first element to be a prompt
//            dummySelector.setDepartmentName("Select your department");
//            dummySelector.setId("none");
                // MobileNotification.add(0, dummySelector);

//            DepartmentSpinAdapter depAdapter = new DepartmentSpinAdapter(NewNotificationActivity.this, R.layout.spinner_selector, R.layout.spinner_dropdown, MobileNotification);
//            sp_Department.setAdapter(depAdapter);
//                sp_Department.setSelection(-1);

                Toast.makeText(getBaseContext(), "", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getBaseContext(), "Error retrieving notifications, Probably bad network connection!", Toast.LENGTH_LONG).show();
            }

//        mProgressBar.setVisibility(ProgressBar.GONE);
//        sp_Department.setVisibility(Spinner.VISIBLE);


        }
    }
    private class ProgressFilter implements ServiceFilter {

        @Override
        public ListenableFuture<ServiceFilterResponse> handleRequest(ServiceFilterRequest request, NextServiceFilterCallback nextServiceFilterCallback) {

            final SettableFuture<ServiceFilterResponse> resultFuture = SettableFuture.create();


            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    if (mProgressBar != null) mProgressBar.setVisibility(ProgressBar.VISIBLE);
                }
            });

            ListenableFuture<ServiceFilterResponse> future = nextServiceFilterCallback.onNext(request);

            Futures.addCallback(future, new FutureCallback<ServiceFilterResponse>() {
                @Override
                public void onFailure(Throwable e) {
                    resultFuture.setException(e);
                }

                @Override
                public void onSuccess(ServiceFilterResponse response) {
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            if (mProgressBar != null) mProgressBar.setVisibility(ProgressBar.GONE);
                        }
                    });

                    resultFuture.set(response);
                }
            });

            return resultFuture;
        }
    }
}