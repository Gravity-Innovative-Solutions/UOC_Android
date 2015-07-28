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
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import java.net.MalformedURLException;

import in.gravitykerala.universityofcalicut.Models.MobileUserRegistrationDTO;


public class Registration extends AppCompatActivity implements GravitySupport {
    EditText name, email, phn;
    String MobilePattern = "[0-9]{10}";
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    //    Context currentContext;
    SharedPreferences prefs;
    private MobileServiceClient mClient;
    private ProgressBar mProgressBar;
    private MobileServiceTable<MobileUserRegistrationDTO> mToDoTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mProgressBar = (ProgressBar) findViewById(R.id.loadingProgressBar);
        mProgressBar.setVisibility(ProgressBar.GONE);
        try {
            // Create the Mobile Service Client instance, using the provided
            // Mobile Service URL and key
            mClient = new MobileServiceClient(
                    "https://universityofcalicut.azure-mobile.net/",
                    "XWXXhaCoiYqzzERpfsqnhpJuQBgCAw42",
                    this);

            // Get the Mobile Service Table instance to use
            mToDoTable = mClient.getTable(MobileUserRegistrationDTO.class);

            // mTextNewToDo = (EditText) findViewById(R.id.textNewToDo);
            name = (EditText) findViewById(R.id.name);
            // Create an adapter to bind the items with the view
            //mAdapter = new ToDoItemAdapter(this, R.layout.row_list_to_do);

            email = (EditText) findViewById(R.id.email);
            phn = (EditText) findViewById(R.id.phn_no);
            //listViewToDo.setAdapter(mAdapter);

            // Load the items from the Mobile Service
            // refreshItemsFromTable();

        } catch (MalformedURLException e) {
            //createAndShowDialog(new Exception("There was an error creating the Mobile Service. Verify the URL"), "Error");
        }
        prefs = this.getSharedPreferences(KEY_PREFERENCE_ID, Context.MODE_APPEND);
//        currentContext = this;
        Button register = (Button) findViewById(R.id.button_register);
//        name = (EditText) findViewById(R.id.name);
//////        final String name_s = name.toString();
////
//        email = (EditText) findViewById(R.id.email);
////        final String email_s = email.toString();
//        phn = (EditText) findViewById(R.id.phn_no);
//
//        final String phn_s = phn.toString();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mClient == null) {
                    return;
                }

                // Create a new item
                final MobileUserRegistrationDTO item = new MobileUserRegistrationDTO();

                item.uName = (name.getText().toString());
                item.Phno = (phn.getText().toString());
                item.Email = (email.getText().toString());
                if (item.uName.isEmpty() || email.getText().toString().isEmpty() || phn.getText().toString().isEmpty()) {
                    Toast.makeText(Registration.this, "fill all the fields", Toast.LENGTH_SHORT).show();
//
                } else if (!item.Email.matches(emailPattern)) {
                    Toast.makeText(getApplicationContext(), "Enter valid email address", Toast.LENGTH_SHORT).show();
                } else if (!item.Phno.matches(MobilePattern)) {
                    Toast.makeText(getApplicationContext(), "Please enter valid number", Toast.LENGTH_SHORT).show();
                } else {


                    // item.setComplete(false);

                    // Insert the new item
                    AsyncRegister registerAsync = new AsyncRegister();
                    registerAsync.execute(item);
//
//                    name.setText("");
//                    phn.setText("");
//                    email.setText("");
                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_registration, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    private class AsyncRegister extends AsyncTask<MobileUserRegistrationDTO, Void, Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected void onCancelled(Boolean aBoolean) {
            super.onCancelled(aBoolean);
            mProgressBar.setVisibility(ProgressBar.GONE);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            mProgressBar.setVisibility(ProgressBar.GONE);
        }

        @Override
        protected void onPostExecute(Boolean resultSuccess) {
            super.onPostExecute(resultSuccess);
            mProgressBar.setVisibility(ProgressBar.GONE);
            if (resultSuccess) {
                prefs.edit().putBoolean(KEY_FIRST_LAUNCH_REGISTRATION, false).apply(); //Dont load this activity again

            } else {
                Toast.makeText(Registration.this, "Registration Failed, You can register later...", Toast.LENGTH_SHORT).show();
            }
            Intent i;
            if (prefs.getBoolean(KEY_FIRST_LAUNCH_COURSE_PREF, true)) {
                i = new Intent(Registration.this, CourseSelectActivity.class);
            } else {
                i = new Intent(Registration.this, HomeDrawer.class);
            }

            startActivity(i);
            finish();
        }

        @Override
        protected Boolean doInBackground(MobileUserRegistrationDTO... params) {

            try {
                final MobileUserRegistrationDTO entity = mToDoTable.insert(params[0]).get();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

        }

    }


}
