package in.gravitykerala.universityofcalicut;


import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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

import in.gravitykerala.universityofcalicut.Adapters.NotificationItemAdapter;
import in.gravitykerala.universityofcalicut.Models.newMobileNotification;

public class NotificationActivity extends AppCompatActivity implements GravitySupport {

    SharedPreferences prefs;



    /**
     * Mobile Service Client reference
     */
    public static MobileServiceClient mClient;

    /**
     * Mobile Service Table used to access data
     */
    private MobileServiceTable<newMobileNotification> mToDoTable;

    /**
     * Adapter to sync the items list with the view
     */
    private NotificationItemAdapter mAdapter;

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
        setContentView(R.layout.activity_notification);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setIcon(R.drawable.back_icon);

        prefs = this.getSharedPreferences(KEY_PREFERENCE_ID, Context.MODE_APPEND);
        mProgressBar = (ProgressBar) findViewById(R.id.loadingProgressBar);

        buttonRefresh = (Button) findViewById(R.id.button_refresh);
        // Initialize the progress bar
        //mProgressBar.setVisibility(ProgressBar.GONE);

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


            // Get the Mobile Service Table instance to use
            mToDoTable = mClient.getTable("newMobileNotification", newMobileNotification.class);

            //mTextNewToDo = (EditText) findViewById(R.id.textNewToDo);

            // Create an adapter to bind the items with the view
            mAdapter = new NotificationItemAdapter(this, R.layout.row_list_notification);
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
        if (NotificationActivity.mClient == null) {
            try {
                NotificationActivity.mClient = new MobileServiceClient(CLOUD_SERVICE_URI, CLOUD_SERVICE_KEY, context);
                Log.d("PushNotification:", "registering");
                NotificationsManager.handleNotifications(context, GCM_PUSH_SENDER_ID, PushNotificationHandler.class);
                Log.d("PushNotification:", "registered");
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
    public void checkItem(final newMobileNotification item) {
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
//                    Toast.makeText(NotificationActivity.this, "Refreshing", Toast.LENGTH_SHORT).show();
                    String selectedCourse = prefs.getString(KEY_SELECTED_COURSE_ID, "none");
                    Log.d("NotificationRefresh:", "Course:" + selectedCourse);
                    Log.d("NotificationRefresh:", "Refreshing");
                    //final List<newMobileNotification> results =  mToDoTable.execute().get();
                    final List<newMobileNotification> results = mToDoTable.where().field("courseId").eq(selectedCourse).or().field("courseId").eq((String) null).execute().get();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter.clear();

                            for (newMobileNotification item : results) {
                                mAdapter.add(item);
                            }

                        }
                    });

                    Log.d("NotificationRefresh:", "Refresh Success");
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d("NotificationRefresh", "Refresh Fail");
//                    Toast.makeText(NotificationActivity.this, "Refresh Failed, Check Network Connection!!!", Toast.LENGTH_LONG).show();
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