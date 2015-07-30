package in.gravitykerala.universityofcalicut;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.List;

import in.gravitykerala.universityofcalicut.dbHelpers.DbQuestionPaperHelper;
import in.gravitykerala.universityofcalicut.dbHelpers.DbSyllabusSdeHelper;


public class QuestionPaperActivity extends ActionBarActivity {
    Context currentContext;
    DbQuestionPaperHelper dataDb;
    Spinner spinnerDepartment, spinnerCourse, spinnerSubject;
    Button buttonGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_paper);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        currentContext = this;

        spinnerDepartment = (Spinner) findViewById(R.id.spinner_qp_questionPaper);
        spinnerCourse = (Spinner) findViewById(R.id.spinner_qp_course);
        spinnerSubject = (Spinner) findViewById(R.id.spinner_qp_subject);
        buttonGet = (Button) findViewById(R.id.button_qp_get_paper);

        dataDb = new DbQuestionPaperHelper(getApplication());
        spinnerDepartment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, final int position, long arg3) {
                ArrayAdapter<String> spinnerAdapter;
                if (position == 0) {
                    spinnerAdapter = new ArrayAdapter<String>(currentContext, R.layout.spinner_selector, getResources().getStringArray(R.array.spinner_select_previous));
                    spinnerCourse.setVisibility(Spinner.GONE);
                    spinnerSubject.setVisibility(Spinner.GONE);
                } else {
                    switch (position) {
                        case 1:
                            dataDb.setTable(DbQuestionPaperHelper.TABLE_QP_2011);
                            break;
                        case 2:
                            dataDb.setTable(DbQuestionPaperHelper.TABLE_QP_2014);
                            break;
                        case 3:
                            dataDb.setTable(DbQuestionPaperHelper.TABLE_SM_2011);
                            break;
                        case 4:
                            dataDb.setTable(DbQuestionPaperHelper.TABLE_SM_2014);
                            break;
                    }
                    List<String> resultStringList = dataDb.getCourses();
                    spinnerAdapter = new ArrayAdapter<String>(currentContext, R.layout.spinner_selector, resultStringList);
                    spinnerCourse.setVisibility(Spinner.VISIBLE);
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
                    spinnerSubject.setVisibility(Spinner.GONE);
                } else {

                    String selectedCourse = String.valueOf(spinnerCourse.getSelectedItem());

                    List<String> resultStringList = dataDb.getSubjects(selectedCourse);

                    spinnerAdapter = new ArrayAdapter<String>(currentContext, R.layout.spinner_selector, resultStringList);
                    spinnerSubject.setVisibility(Spinner.VISIBLE);
                }

                spinnerAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
                spinnerSubject.setAdapter(spinnerAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerSubject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    //TODO make the button invisible
                    buttonGet.setVisibility(Button.GONE);
                } else {
                    //TODO make the button visible
                    buttonGet.setVisibility(Button.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ;
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(currentContext, R.layout.spinner_selector, getResources().getStringArray(R.array.spinner_select_questionPaper));
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinnerDepartment.setAdapter(spinnerAdapter);

        buttonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String selectedCourse = String.valueOf(spinnerCourse.getSelectedItem());
                String selectedSubject = String.valueOf(spinnerSubject.getSelectedItem());


                String downloadUrl = dataDb.getURL(selectedCourse, selectedSubject);
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
