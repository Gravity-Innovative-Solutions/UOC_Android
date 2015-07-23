package in.gravitykerala.universityofcalicut;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Registration extends AppCompatActivity implements GravitySupport {
    EditText name, email, phn;
    String MobilePattern = "[0-9]{10}";
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    //    Context currentContext;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        prefs = this.getSharedPreferences(KEY_PREFERENCE_ID, Context.MODE_APPEND);
//        currentContext = this;
        Button register = (Button) findViewById(R.id.button_register);
        name = (EditText) findViewById(R.id.name);
////        final String name_s = name.toString();
//
        email = (EditText) findViewById(R.id.email);
//        final String email_s = email.toString();
        phn = (EditText) findViewById(R.id.phn_no);
//
//        final String phn_s = phn.toString();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || phn.getText().toString().isEmpty()) {
                    Toast.makeText(Registration.this, "fill all the fields", Toast.LENGTH_SHORT).show();
//
                } else if (!email.getText().toString().matches(emailPattern)) {
                    Toast.makeText(getApplicationContext(), "Enter valid email address", Toast.LENGTH_SHORT).show();
                } else if (!phn.getText().toString().matches(MobilePattern)) {
                    Toast.makeText(getApplicationContext(), "Please enter valid number", Toast.LENGTH_SHORT).show();
                } else {


                    Intent i;
                    if (prefs.getBoolean(KEY_FIRST_LAUNCH_COURSE_PREF, true)) {
                        i = new Intent(Registration.this, CourseSelectActivity.class);
                    } else {
                        i = new Intent(Registration.this, HomeDrawer.class);
                    }
                    prefs.edit().putBoolean(KEY_FIRST_LAUNCH_REGISTRATION, false).apply(); //Dont load this activity again
                    startActivity(i);
                    finish();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration, menu);
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
