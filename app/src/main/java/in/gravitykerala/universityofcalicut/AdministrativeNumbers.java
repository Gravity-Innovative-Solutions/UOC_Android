package in.gravitykerala.universityofcalicut;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class AdministrativeNumbers extends AppCompatActivity {

    private static final int PHONE_NUMBER_MINIMUM_DIGITS = 5;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrative_numbers);
        TextView myPhone = (TextView) findViewById(R.id.textView71);
//
//
//
//        Linkify.addLinks(myPhone, Linkify.PHONE_NUMBERS);

//        Linkify.addLinks(t_vc, Linkify.PHONE_NUMBERS);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }

    public static final Linkify.MatchFilter sPhoneNumberMatchFilter = new Linkify.MatchFilter() {

        public final boolean acceptMatch(CharSequence s, int start, int end) {

            // make sure there was a whitespace before pattern
            if (!Character.isWhitespace(s.charAt(start - 1))) {
                return false;
            }

            // minimum length
            int digitCount = 0;
            for (int i = start; i < end; i++) {
                if (Character.isDigit(s.charAt(i))) {
                    digitCount++;
                    if (digitCount >= PHONE_NUMBER_MINIMUM_DIGITS) {
                        return true;
                    }
                }
            }
            return false;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_administrative_numbers, menu);
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
