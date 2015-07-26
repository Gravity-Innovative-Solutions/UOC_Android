package in.gravitykerala.universityofcalicut;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import java.net.MalformedURLException;

import in.gravitykerala.universityofcalicut.Models.MobileVcEnqeryDTO;


public class TalktoVC extends AppCompatActivity {
    EditText name, email, phn, messages;
    Spinner spinner;
    Button submit;
    String MobilePattern = "[0-9]{10}";
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private MobileServiceClient mClient;

    private ProgressBar mProgressBar;
    private MobileServiceTable<MobileVcEnqeryDTO> mToDoTable;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talkto_vc);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        try {
            // Create the Mobile Service Client instance, using the provided
            // Mobile Service URL and key
            mClient = new MobileServiceClient(
                    "https://universityofcalicut.azure-mobile.net/",
                    "XWXXhaCoiYqzzERpfsqnhpJuQBgCAw42",
                    this);

            // Get the Mobile Service Table instance to use
            mToDoTable = mClient.getTable(MobileVcEnqeryDTO.class);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        name = (EditText) findViewById(R.id.name);
        final String name_s = name.toString();

        email = (EditText) findViewById(R.id.email);
        final String email_s = email.toString();
        phn = (EditText) findViewById(R.id.phn_no);
        messages = (EditText) findViewById(R.id.msg);
        final String phn_s = phn.toString();
        submit = (Button) findViewById(R.id.button_submit);
        spinner = (Spinner) findViewById(R.id.spinner);
        } catch (MalformedURLException e) {
            //createAndShowDialog(new Exception("There was an error creating the Mobile Service. Verify the URL"), "Error");
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mClient == null) {
                    return;
                }

                // Create a new item
                final MobileVcEnqeryDTO item = new MobileVcEnqeryDTO();

                item.uName = (name.getText().toString());
                item.Phno = (phn.getText().toString());
                item.Email = (email.getText().toString());
                item.content = (messages.getText().toString());
                item.enquiry = (spinner.getSelectedItem().toString());
                if (name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || phn.getText().toString().isEmpty() || messages.getText().toString().isEmpty()) {
                    Toast.makeText(TalktoVC.this, "fill all the fields", Toast.LENGTH_SHORT).show();

                } else if (!email.getText().toString().matches(emailPattern)) {
                    Toast.makeText(getApplicationContext(), "Enter valid email address", Toast.LENGTH_SHORT).show();
                } else if (!phn.getText().toString().matches(MobilePattern)) {
                    Toast.makeText(getApplicationContext(), "Please enter valid number", Toast.LENGTH_SHORT).show();
                } else {


                    // item.setComplete(false);

                    // Insert the new item
                    new AsyncTask<Void, Void, Void>() {
                        @Override
                        protected Void doInBackground(Void... params) {
                            try {
                                final MobileVcEnqeryDTO entity = mToDoTable.insert(item).get();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(TalktoVC.this, "THANK YOU", Toast.LENGTH_LONG).show();
                                    }
                                });
                            } catch (Exception e) {
                                // createAndShowDialog(e, "Error");

                            }

                            return null;
                        }
                    }.execute();

                    name.setText("");
                    phn.setText("");
                    email.setText("");
                    messages.setText("");
                    spinner.setSelection(0);
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_talkto_vc, menu);
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
