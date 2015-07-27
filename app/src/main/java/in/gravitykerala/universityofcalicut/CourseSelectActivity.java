package in.gravitykerala.universityofcalicut;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.microsoft.windowsazure.mobileservices.MobileServiceException;
import com.microsoft.windowsazure.mobileservices.http.NextServiceFilterCallback;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilter;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterRequest;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.notifications.NotificationsManager;

import java.util.List;
import java.util.concurrent.ExecutionException;

import in.gravitykerala.universityofcalicut.Adapters.CourseItemAdapter;
import in.gravitykerala.universityofcalicut.Adapters.CourseSpinAdapter;
import in.gravitykerala.universityofcalicut.Adapters.DepartmentSpinAdapter;
import in.gravitykerala.universityofcalicut.Models.CourseItemDTO;
import in.gravitykerala.universityofcalicut.Models.DepartmentDTO;


public class CourseSelectActivity extends AppCompatActivity implements GravitySupport {

    private MobileServiceTable<CourseItemDTO> courseTable;
    private MobileServiceTable<DepartmentDTO> departmentTable;
    private CourseItemAdapter courseAdapter;
    private DepartmentSpinAdapter departmentadapter;
    /**
     * Progress spinner to use for table operations
     */
    private ProgressBar mProgressBar;
    private Button buttonUpdate;

    CheckBox cb_ExamNotifications, cb_VCsDesk, cb_UOC_Newa, cb_UOC_Orders, cb_DistanceEdu;
    Spinner sp_Department, sp_Course;

    String selectedCourseId = "none";
    String selectedDepartmentId = "none";


    SharedPreferences prefs;
//    Context currentContext;

    AsyncDepartmentLoader departmentAsyncTask;
    AsyncCourseLoader courseAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_preference_activity);
        prefs = this.getSharedPreferences(KEY_PREFERENCE_ID, Context.MODE_APPEND);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        prefs = this.getSharedPreferences(KEY_PREFERENCE_ID, Context.MODE_APPEND);
//        String selectedCourse = prefs.getString(KEY_SELECTED_COURSE_ID, "none");
//        if (!selectedCourse.equals("none")) {
//            Intent mainIntent = new Intent(this, HomeDrawer.class);
//            this.startActivity(mainIntent);
//            finish();
//            return;
//        }


        cb_ExamNotifications = (CheckBox) findViewById(R.id.checkBox_examNotifications);
        cb_DistanceEdu = (CheckBox) findViewById(R.id.checkBox_Distance_Notifications);
        cb_UOC_Newa = (CheckBox) findViewById(R.id.checkBox_UOC_News);
        cb_UOC_Orders = (CheckBox) findViewById(R.id.checkBox_UOC_Orders);
        cb_VCsDesk = (CheckBox) findViewById(R.id.checkBox_VCs_Desk);

        sp_Course = (Spinner) findViewById(R.id.spinner_Course);
        sp_Department = (Spinner) findViewById(R.id.spinner_Department);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar_CourseSelection);
        buttonUpdate = (Button) findViewById(R.id.button_apply_preference);
        mProgressBar.setVisibility(ProgressBar.GONE);

        cb_ExamNotifications.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    refreshDepartmentItems();

                } else {
                    if (courseAsyncTask != null) {
                        courseAsyncTask.cancel(true);
                    }
                    if (departmentAsyncTask != null) {
                        departmentAsyncTask.cancel(true);
                    }
                    sp_Department.setVisibility(Spinner.GONE);
                    sp_Course.setVisibility(Spinner.GONE);
                    mProgressBar.setVisibility(ProgressBar.GONE);

                    selectedCourseId = "none";
                    selectedDepartmentId = "none";
                }
            }
        });
        sp_Department.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selectedDepartmentId = (String) view.getTag();
                Log.d("selectedDepartmentId:", selectedDepartmentId);
                if ("none".equals(selectedDepartmentId)) {
                    if (courseAsyncTask != null) {
                        courseAsyncTask.cancel(true);
                    }
                    sp_Course.setVisibility(Spinner.GONE);
                    selectedCourseId = "none";
                } else {
                    refreshCourseItems();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp_Course.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCourseId = (String) view.getTag();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //refreshCourseItems();

                Log.d("selectedCourseId:", selectedCourseId);
                Log.d("selectedDepartmentId:", selectedDepartmentId);

                if (!cb_ExamNotifications.isChecked()) //No Exam notification needed
                {
                    selectedCourseId = "none";
                    selectedDepartmentId = "none";
                    prefs.edit().putString(KEY_SELECTED_COURSE_ID, selectedCourseId).apply();
                    prefs.edit().putString(KEY_SELECTED_DEPARTMENT_ID, selectedDepartmentId).apply();
                    prefs.edit().putBoolean(KEY_EXAM_NOTIFICATION_NEEDED, false).apply();
                } else {
                    prefs.edit().putString(KEY_SELECTED_COURSE_ID, selectedCourseId).apply();
                    prefs.edit().putString(KEY_SELECTED_DEPARTMENT_ID, selectedDepartmentId).apply();
                    prefs.edit().putBoolean(KEY_EXAM_NOTIFICATION_NEEDED, true).apply();
                }

                if (cb_DistanceEdu.isChecked()) {
                    prefs.edit().putBoolean(KEY_DISTANCE_EDUCATION_NEEDED, true).apply();
                } else {
                    prefs.edit().putBoolean(KEY_DISTANCE_EDUCATION_NEEDED, false).apply();
                }

                if (cb_VCsDesk.isChecked()) {
                    prefs.edit().putBoolean(KEY_VC_DESK_NEEDED, true).apply();
                } else {
                    prefs.edit().putBoolean(KEY_VC_DESK_NEEDED, false).apply();
                }

                if (cb_UOC_Orders.isChecked()) {
                    prefs.edit().putBoolean(KEY_UOC_ORDERS_NEEDED, true).apply();
                } else {
                    prefs.edit().putBoolean(KEY_UOC_ORDERS_NEEDED, false).apply();
                }

                if (cb_UOC_Newa.isChecked()) {
                    prefs.edit().putBoolean(KEY_UOC_NEWS_NEEDED, true).apply();
                } else {
                    prefs.edit().putBoolean(KEY_UOC_NEWS_NEEDED, false).apply();
                }

                prefs.edit().putBoolean(KEY_FIRST_LAUNCH_COURSE_PREF, false).apply(); //Dont load this activity again

                NotificationsManager.handleNotifications(CourseSelectActivity.this, GCM_PUSH_SENDER_ID, PushNotificationHandler.class);

                Intent i = new Intent(CourseSelectActivity.this, HomeDrawer.class);
                startActivity(i);
                finish();
            }
        });

        try {

            NotificationActivity.initializeMobileService(this);
            //NotificationActivity.mClient.withFilter(new ProgressFilter());

            courseTable = NotificationActivity.mClient.getTable("MobileCourse", CourseItemDTO.class);
            departmentTable = NotificationActivity.mClient.getTable("MobileDepartmentDTO", DepartmentDTO.class);

            //courseAdapter = new CourseItemAdapter(this, R.layout.row_list_course);
            //ListView listviewCourse = (ListView) findViewById(R.id.listView_courses);
            //listviewCourse.setAdapter(courseAdapter);

            //refreshCourseItems();

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

    private void refreshDepartmentItems() {

        // Get the items that weren't marked as completed and add them in the
        // adapter
        departmentAsyncTask = new AsyncDepartmentLoader();
        departmentAsyncTask.execute();
    }

    private class AsyncDepartmentLoader extends AsyncTask<Void, Void, List<DepartmentDTO>> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected List<DepartmentDTO> doInBackground(Void... params) {
            List<DepartmentDTO> results = null;
            try {
                results = departmentTable.execute().get();
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
        protected void onCancelled(List<DepartmentDTO> departmentDTOs) {
            super.onCancelled(departmentDTOs);
            mProgressBar.setVisibility(ProgressBar.GONE);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            mProgressBar.setVisibility(ProgressBar.GONE);
        }

        @Override
        protected void onPostExecute(List<DepartmentDTO> departmentItemDTOs) {
            super.onPostExecute(departmentItemDTOs);

            if (departmentItemDTOs != null && !departmentItemDTOs.isEmpty()) //Successfull results
            {
                DepartmentDTO dummySelector = new DepartmentDTO(); //Used for showing the first element to be a prompt
                dummySelector.setDepartmentName("Select your department");
                dummySelector.setId("none");
                departmentItemDTOs.add(0, dummySelector);

                DepartmentSpinAdapter depAdapter = new DepartmentSpinAdapter(CourseSelectActivity.this, R.layout.spinner_selector, R.layout.spinner_dropdown, departmentItemDTOs);
                sp_Department.setAdapter(depAdapter);
//                sp_Department.setSelection(-1);

                Toast.makeText(getBaseContext(), "Please Select your Department", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getBaseContext(), "Error retrieving departments, Probably bad network connection!", Toast.LENGTH_LONG).show();
            }

            mProgressBar.setVisibility(ProgressBar.GONE);
            sp_Department.setVisibility(Spinner.VISIBLE);


        }
    }

    private void refreshCourseItems() {

        // Get the items that weren't marked as completed and add them in the
        // adapter

        courseAsyncTask = new AsyncCourseLoader();
        courseAsyncTask.execute();

    }

    private class AsyncCourseLoader extends AsyncTask<Void, Void, List<CourseItemDTO>> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected List<CourseItemDTO> doInBackground(Void... params) {
            List<CourseItemDTO> results = null;
            try {
                results = courseTable.where().field("DepartmentId").eq(selectedDepartmentId).execute().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return results;
        }

        @Override
        protected void onCancelled(List<CourseItemDTO> courseDTOs) {
            super.onCancelled(courseDTOs);
            mProgressBar.setVisibility(ProgressBar.GONE);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            mProgressBar.setVisibility(ProgressBar.GONE);
        }

        @Override
        protected void onPostExecute(List<CourseItemDTO> departmentItemDTOs) {
            super.onPostExecute(departmentItemDTOs);

            if (departmentItemDTOs != null && !departmentItemDTOs.isEmpty()) //Successfull results
            {
                CourseItemDTO dummySelector = new CourseItemDTO(); //Used for showing the first element to be a prompt
                dummySelector.courseName = "Select your Course";
                dummySelector.courseId = "none";
                departmentItemDTOs.add(0, dummySelector);

                CourseSpinAdapter depAdapter = new CourseSpinAdapter(CourseSelectActivity.this, R.layout.spinner_selector, R.layout.spinner_dropdown, departmentItemDTOs);
                sp_Course.setAdapter(depAdapter);
//                sp_Department.setSelection(-1);

                Toast.makeText(getBaseContext(), "Please Select your Course", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getBaseContext(), "Error retrieving courses, Probably bad network connection!", Toast.LENGTH_LONG).show();
            }

            mProgressBar.setVisibility(ProgressBar.GONE);
            sp_Department.setVisibility(Spinner.VISIBLE);
            sp_Course.setVisibility(Spinner.VISIBLE);


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
