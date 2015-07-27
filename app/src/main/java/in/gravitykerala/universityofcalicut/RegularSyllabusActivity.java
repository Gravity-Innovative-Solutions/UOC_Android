package in.gravitykerala.universityofcalicut;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.List;

import in.gravitykerala.universityofcalicut.dbHelpers.DbSyllabusRegularHelper;


public class RegularSyllabusActivity extends ActionBarActivity {
    Context currentContext;
    DbSyllabusRegularHelper dataDb;
    Spinner spinnerDepartment, spinnerCourse, spinnerBranch, spinnerScheme, spinnerYear;
    Button buttonGet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.syllabus_regular);
        currentContext = this;

        spinnerDepartment = (Spinner) findViewById(R.id.spinner_department);
        spinnerCourse = (Spinner) findViewById(R.id.spinner_course);
        spinnerBranch = (Spinner) findViewById(R.id.spinner_branch);
        spinnerScheme = (Spinner) findViewById(R.id.spinner_scheme);
        spinnerYear = (Spinner) findViewById(R.id.spinner_year);
        buttonGet = (Button) findViewById(R.id.button_get);

        dataDb = new DbSyllabusRegularHelper(getApplication());
//        dataDb.createDataBase();

        spinnerDepartment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, final int position, long arg3) {
                ArrayAdapter<String> spinnerAdapter;
                if (position == 0) {
                    spinnerAdapter = new ArrayAdapter<String>(currentContext, R.layout.spinner_selector, getResources().getStringArray(R.array.spinner_select_previous));
                } else {
                    String selectedDepartment = String.valueOf(spinnerDepartment.getSelectedItem());

                    List<String> resultStringList = dataDb.getCourses(selectedDepartment);

                    spinnerAdapter = new ArrayAdapter<String>(currentContext, R.layout.spinner_selector, resultStringList);
                }

                spinnerAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
                spinnerCourse.setAdapter(spinnerAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerCourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, final int position, long arg3) {
                ArrayAdapter<String> spinnerAdapter;
                if (position == 0) {
                    spinnerAdapter = new ArrayAdapter<String>(currentContext, R.layout.spinner_selector, getResources().getStringArray(R.array.spinner_select_previous));
                } else {
                    String selectedDepartment = String.valueOf(spinnerDepartment.getSelectedItem());
                    String selectedCourse = String.valueOf(spinnerCourse.getSelectedItem());

                    List<String> resultStringList = dataDb.getBranches(selectedDepartment, selectedCourse);

                    spinnerAdapter = new ArrayAdapter<String>(currentContext, R.layout.spinner_selector, resultStringList);
                }

                spinnerAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
                spinnerBranch.setAdapter(spinnerAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerBranch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, final int position, long arg3) {
                ArrayAdapter<String> spinnerAdapter;
                if (position == 0) {
                    spinnerAdapter = new ArrayAdapter<String>(currentContext, R.layout.spinner_selector, getResources().getStringArray(R.array.spinner_select_previous));
                } else {
                    String selectedDepartment = String.valueOf(spinnerDepartment.getSelectedItem());
                    String selectedCourse = String.valueOf(spinnerCourse.getSelectedItem());
                    String selectedBranch = String.valueOf(spinnerBranch.getSelectedItem());

                    List<String> resultStringList = dataDb.getSchemes(selectedDepartment, selectedCourse, selectedBranch);

                    spinnerAdapter = new ArrayAdapter<String>(currentContext, R.layout.spinner_selector, resultStringList);
                }

                spinnerAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
                spinnerScheme.setAdapter(spinnerAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerScheme.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, final int position, long arg3) {
                ArrayAdapter<String> spinnerAdapter;
                if (position == 0) {
                    spinnerAdapter = new ArrayAdapter<String>(currentContext, R.layout.spinner_selector, getResources().getStringArray(R.array.spinner_select_previous));
                } else {
                    String selectedDepartment = String.valueOf(spinnerDepartment.getSelectedItem());
                    String selectedCourse = String.valueOf(spinnerCourse.getSelectedItem());
                    String selectedBranch = String.valueOf(spinnerBranch.getSelectedItem());
                    String selectedScheme = String.valueOf(spinnerScheme.getSelectedItem());

                    List<String> resultStringList = dataDb.getYears(selectedDepartment, selectedCourse, selectedBranch, selectedScheme);

                    spinnerAdapter = new ArrayAdapter<String>(currentContext, R.layout.spinner_selector, resultStringList);
                }

                spinnerAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
                spinnerYear.setAdapter(spinnerAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    //TODO make the button invisible
                    buttonGet.setVisibility(View.GONE);
                } else {
                    //TODO make the button visible
                    buttonGet.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        List<String> resultDepartmentsList = dataDb.getDepartments();
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(currentContext, R.layout.spinner_selector, resultDepartmentsList);
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinnerDepartment.setAdapter(spinnerAdapter);

        buttonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedDepartment = String.valueOf(spinnerDepartment.getSelectedItem());
                String selectedCourse = String.valueOf(spinnerCourse.getSelectedItem());
                String selectedBranch = String.valueOf(spinnerBranch.getSelectedItem());
                String selectedScheme = String.valueOf(spinnerScheme.getSelectedItem());
                String selectedYear = String.valueOf(spinnerYear.getSelectedItem());

                String downloadUrl = dataDb.getURL(selectedDepartment, selectedCourse, selectedBranch, selectedScheme, selectedYear);
                Log.d("downloadUrl: ", downloadUrl);

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(downloadUrl));
                startActivity(browserIntent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        dataDb.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
