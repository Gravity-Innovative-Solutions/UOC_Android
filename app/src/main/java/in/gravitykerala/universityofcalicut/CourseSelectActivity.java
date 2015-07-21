package in.gravitykerala.universityofcalicut;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.microsoft.windowsazure.mobileservices.http.NextServiceFilterCallback;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilter;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterRequest;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import java.util.List;

import in.gravitykerala.universityofcalicut.Adapters.CourseItemAdapter;
import in.gravitykerala.universityofcalicut.Models.CourseItemDTO;


public class CourseSelectActivity extends AppCompatActivity implements GravitySupport {

    private MobileServiceTable<CourseItemDTO> courseTable;
    private CourseItemAdapter courseAdapter;
    /**
     * Progress spinner to use for table operations
     */
    private ProgressBar mProgressBar;
    private Button buttonRefresh;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = this.getSharedPreferences(KEY_PREFERENCE_ID, Context.MODE_APPEND);
        String selectedCourse = prefs.getString(KEY_SELECTED_COURSE_ID, "none");
        if (!selectedCourse.equals("none")) {
            Intent mainIntent = new Intent(this, HomeDrawer.class);
            this.startActivity(mainIntent);
            finish();
            return;
        }

        setContentView(R.layout.activity_course_select);

        mProgressBar = (ProgressBar) findViewById(R.id.loadingProgressBar);
        buttonRefresh = (Button) findViewById(R.id.button_refresh);
        mProgressBar.setVisibility(ProgressBar.GONE);
        buttonRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rereshCourseItems();
            }
        });

        try {

            NotificationActivity.initializeMobileService(this);
            //NotificationActivity.mClient.withFilter(new ProgressFilter());

            courseTable = NotificationActivity.mClient.getTable("MobileCourse", CourseItemDTO.class);
            courseAdapter = new CourseItemAdapter(this, R.layout.row_list_course);
            ListView listviewCourse = (ListView) findViewById(R.id.listView_courses);
            listviewCourse.setAdapter(courseAdapter);

            rereshCourseItems();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course_select, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void rereshCourseItems() {

        // Get the items that weren't marked as completed and add them in the
        // adapter

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    final List<CourseItemDTO> results = courseTable.execute().get();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            courseAdapter.clear();

                            for (CourseItemDTO item : results) {
                                courseAdapter.add(item);
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();

                }

                return null;
            }
        }.execute();

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
