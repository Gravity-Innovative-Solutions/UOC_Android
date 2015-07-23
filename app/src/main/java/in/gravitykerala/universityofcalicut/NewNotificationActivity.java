package in.gravitykerala.universityofcalicut;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.http.NextServiceFilterCallback;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilter;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterRequest;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.notifications.NotificationsManager;

import java.net.MalformedURLException;
import java.util.List;

import in.gravitykerala.universityofcalicut.Models.MobileNotification;

public class NewNotificationActivity extends Activity {

    public static final String SENDER_ID = "387718248282";

    /**
     * Mobile Service Client reference
     */
    public static MobileServiceClient mClient;

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

        buttonRefresh = (Button) findViewById(R.id.button_refresh);
        // Initialize the progress bar
        mProgressBar.setVisibility(ProgressBar.GONE);

        buttonRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshItemsFromTable();

            }

        });
        try {
            // Create the Mobile Service Client instance, using the provided
            // Mobile Service URL and key

            initializeMobileService(this);
            mClient.withFilter(new ProgressFilter());

            String api = null;
            if (getIntent().getStringExtra("NOTIFICATION_TYPE").toString().equals("NOTIFICATION_ORDERS")) {
                api = "MobileUniversityOrders";
            }
            if (getIntent().getStringExtra("NOTIFICATION_TYPE").toString().equals("NOTIFICATION_VC_DESK")) {
                api = "MobileVcDesk";
            }
            if (getIntent().getStringExtra("NOTIFICATION_TYPE").toString().equals("NOTIFICATION_NEWS")) {
                api = "MobileNews";
            }
            if (getIntent().getStringExtra("NOTIFICATION_TYPE").toString().equals("EXAM_NOTIFICATIONS")) {
                api = "MobilePareekshabhavanNotification";
            }
            if (getIntent().getStringExtra("NOTIFICATION_TYPE").toString().equals("EXAM_RESULT")) {
                api = "MobileResult";
            }
            if (getIntent().getStringExtra("NOTIFICATION_TYPE").toString().equals("EXAM_TIMETABLE")) {
                api = "MobileTimeTable";
            }
            if (getIntent().getStringExtra("NOTIFICATION_TYPE").toString().equals("DISTANCE_NOTIFICATION")) {
                api = "MobileDistanceEducationNotification";
            }
            if (getIntent().getStringExtra("NOTIFICATION_TYPE").toString().equals("DISTANCE_CONTACT_CLASS")) {
                api = "MobileContactClass";
            }
            if (getIntent().getStringExtra("NOTIFICATION_TYPE").toString().equals("DISTANCE_STUDY_MATERIAL")) {
                api = "MobileStudyMaterials";
            }
            if (getIntent().getStringExtra("NOTIFICATION_TYPE").toString().equals("DISTANCE_QUESTION_BANK")) {
                api = "MobileQuestionBank";
            }


            // Get the Mobile Service Table instance to use
            mToDoTable = mClient.getTable(api, MobileNotification.class);

            //mTextNewToDo = (EditText) findViewById(R.id.textNewToDo);

            // Create an adapter to bind the items with the view
            mAdapter = new NewNotificationItemAdapter(this, R.layout.single_row_list_notification);
            ListView listViewToDo = (ListView) findViewById(R.id.listViewToDo);
            listViewToDo.setAdapter(mAdapter);

            // Load the items from the Mobile Service
            refreshItemsFromTable();

        } catch (Exception e) {
            e.printStackTrace();
            createAndShowDialog(new Exception("There was an error creating the Mobile Service. Verify the URL"), "Error");
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
            refreshItemsFromTable();
        }

        return true;
    }

    public static void initializeMobileService(Context context) {
        if (mClient == null) {
            try {
                mClient = new MobileServiceClient("https://universityofcalicut.azure-mobile.net/", "XWXXhaCoiYqzzERpfsqnhpJuQBgCAw42", context);
                NotificationsManager.handleNotifications(context, SENDER_ID, PushNotificationHandler.class);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                //TODO check for Netowrk connectivity and add Exception handling

            }
        }
    }


    /**
     * Mark an item as completed
     *
     * @param item
     *            The item to mark
     */
    /*
    public void checkItem(final MobileNotification item) {
        if (mClient == null) {
            return;
        }

        // Set the item as completed and update it in the table
        item.setComplete(true);


        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    final ToDoItem entity = mToDoTable.update(item).get();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (entity.isComplete()) {
                                mAdapter.remove(entity);
                            }
                        }
                    });
                } catch (Exception e){
                    createAndShowDialog(e, "Error");
                }

                return null;
            }
        }.execute();
    }
*/
    /**
     * Add a new item
     *
     * @param view
     *            The view that originated the call
     */
    /*
    public void addItem(View view) {
        if (mClient == null) {
            return;
        }

        // Create a new item
        final ToDoItem item = new ToDoItem();

        item.setText(mTextNewToDo.getText().toString());
        item.setComplete(false);

        // Insert the new item
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    final ToDoItem entity = mToDoTable.insert(item).get();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(!entity.isComplete()){
                                mAdapter.add(entity);
                            }
                        }
                    });
                } catch (Exception e){
                    createAndShowDialog(e, "Error");

                }

                return null;
            }
        }.execute();

        mTextNewToDo.setText("");
    }
*/

    /**
     * Refresh the list with the items in the Mobile Service Table
     */

    private void refreshItemsFromTable() {

        // Get the items that weren't marked as completed and add them in the
        // adapter

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    final List<MobileNotification> results =
                            mToDoTable.execute().get();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter.clear();

                            for (MobileNotification item : results) {
                                mAdapter.add(item);
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    createAndShowDialog(e, "Error");

                }

                return null;
            }
        }.execute();

    }

    /**
     * Creates a dialog and shows it
     *
     * @param exception The exception to show in the dialog
     * @param title     The dialog title
     */

    private void createAndShowDialog(Exception exception, String title) {
        Throwable ex = exception;
        if (exception.getCause() != null) {
            ex = exception.getCause();
        }
        createAndShowDialog(ex.getMessage(), title);
    }

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