package in.gravitykerala.universityofcalicut;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class AdministrativeNumbers extends AppCompatActivity {

    private static final int PHONE_NUMBER_MINIMUM_DIGITS = 11;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrative_numbers);
        TextView myPhone = (TextView) findViewById(R.id.textView71);
        TextView myPhone1 = (TextView) findViewById(R.id.textView73);
        TextView myPhone2 = (TextView) findViewById(R.id.textView75);
        TextView myPhone3 = (TextView) findViewById(R.id.textView79);
        TextView myPhone4 = (TextView) findViewById(R.id.textView81);
        TextView myPhone5 = (TextView) findViewById(R.id.textView83);
        TextView myPhone6 = (TextView) findViewById(R.id.textView85);
        TextView myPhone7 = (TextView) findViewById(R.id.textView87);
        TextView myPhone8 = (TextView) findViewById(R.id.textView89);
        TextView myPhone9 = (TextView) findViewById(R.id.textView92);
        TextView myPhone10 = (TextView) findViewById(R.id.textView94);
        TextView myPhone11 = (TextView) findViewById(R.id.textView94);
        TextView myPhone12 = (TextView) findViewById(R.id.textView96);
        TextView myPhone13 = (TextView) findViewById(R.id.textView98);
        TextView myPhone14 = (TextView) findViewById(R.id.textView100);
        TextView myPhone15 = (TextView) findViewById(R.id.textView102);
        TextView myPhone16 = (TextView) findViewById(R.id.textView104);
        TextView myPhone17 = (TextView) findViewById(R.id.textView106);
        TextView myPhone18 = (TextView) findViewById(R.id.textView108);
        TextView myPhone19 = (TextView) findViewById(R.id.textView110);
        TextView myPhone20 = (TextView) findViewById(R.id.textView112);
        TextView myPhone21 = (TextView) findViewById(R.id.textView114);
        TextView myPhone22 = (TextView) findViewById(R.id.textView116);
        TextView myPhone23 = (TextView) findViewById(R.id.textView118);
        TextView myPhone24 = (TextView) findViewById(R.id.textView120);
        TextView myPhone25 = (TextView) findViewById(R.id.textView122);
        TextView myPhone26 = (TextView) findViewById(R.id.textView124);
        TextView myPhone27 = (TextView) findViewById(R.id.textView126);
        TextView myPhone28 = (TextView) findViewById(R.id.textView128);
        TextView myPhone29 = (TextView) findViewById(R.id.textView130);
        TextView myPhone30 = (TextView) findViewById(R.id.textView132);
        TextView myPhone31 = (TextView) findViewById(R.id.textView134);
        TextView myPhone32 = (TextView) findViewById(R.id.textView136);
        TextView myPhone33 = (TextView) findViewById(R.id.textView138);
        TextView myPhone34 = (TextView) findViewById(R.id.textView140);
        TextView myPhone35 = (TextView) findViewById(R.id.textView142);
        TextView myPhone36 = (TextView) findViewById(R.id.textView144);
        TextView myPhone37 = (TextView) findViewById(R.id.textView146);
        TextView myPhone38 = (TextView) findViewById(R.id.textView148);
        TextView myPhone39 = (TextView) findViewById(R.id.textView150);
        TextView myPhone40 = (TextView) findViewById(R.id.textView152);
        TextView myPhone41 = (TextView) findViewById(R.id.textView154);

        SpannableString content = new SpannableString("0494-2407102");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        myPhone.setText(content);

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
        myPhone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-2407102"));
                startActivity(callIntent);
            }
        });
        myPhone1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 04942407150"));
                startActivity(callIntent);
            }
        });
        myPhone2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7103"));
                startActivity(callIntent);
            }
        });
        myPhone3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7104"));
                startActivity(callIntent);
            }
        });
        myPhone4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7106"));
                startActivity(callIntent);
            }
        });
        myPhone5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7105"));
                startActivity(callIntent);
            }
        });
        myPhone6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7108"));
                startActivity(callIntent);
            }
        });
        myPhone7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7107"));
                startActivity(callIntent);
            }
        });
        myPhone8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7142"));
                startActivity(callIntent);
            }
        });
        myPhone9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7109"));
                startActivity(callIntent);
            }
        });
        myPhone10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7112"));
                startActivity(callIntent);
            }
        });
        myPhone11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7110"));
                startActivity(callIntent);
            }
        });
        myPhone12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7111"));
                startActivity(callIntent);
            }
        });
        myPhone13.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7123"));
                startActivity(callIntent);
            }
        });
        myPhone14.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7114"));
                startActivity(callIntent);
            }
        });
        myPhone15.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7133"));
                startActivity(callIntent);
            }
        });
        myPhone16.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7125"));
                startActivity(callIntent);
            }
        });
        myPhone17.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7127"));
                startActivity(callIntent);
            }
        });
        myPhone18.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7116"));
                startActivity(callIntent);
            }
        });
        myPhone19.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7115"));
                startActivity(callIntent);
            }
        });
        myPhone20.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7209"));
                startActivity(callIntent);
            }
        });
        myPhone21.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7124"));
                startActivity(callIntent);
            }
        });
        myPhone22.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7121"));
                startActivity(callIntent);
            }
        });
        myPhone23.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7119"));
                startActivity(callIntent);
            }
        });
        myPhone24.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7126"));
                startActivity(callIntent);
            }
        });
        myPhone25.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7122"));
                startActivity(callIntent);
            }
        });
        myPhone26.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7136"));
                startActivity(callIntent);
            }
        });
        myPhone27.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7100"));
                startActivity(callIntent);
            }
        });
        myPhone28.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7132"));
                startActivity(callIntent);
            }
        });
        myPhone29.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7131"));
                startActivity(callIntent);
            }
        });
        myPhone30.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7128"));
                startActivity(callIntent);
            }
        });
        myPhone31.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7138"));
                startActivity(callIntent);
            }
        });
        myPhone32.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7130"));
                startActivity(callIntent);
            }
        });
        myPhone33.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7117"));
                startActivity(callIntent);
            }
        });
        myPhone34.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7444"));
                startActivity(callIntent);
            }
        });
        myPhone35.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7316"));
                startActivity(callIntent);
            }
        });
        myPhone36.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7500"));
                startActivity(callIntent);
            }
        });
        myPhone37.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7401"));
                startActivity(callIntent);
            }
        });
        myPhone38.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7546"));
                startActivity(callIntent);
            }
        });
        myPhone39.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7233"));
                startActivity(callIntent);
            }
        });
        myPhone40.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7227"));
                startActivity(callIntent);
            }
        });
        myPhone41.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7152"));
                startActivity(callIntent);
            }
        });

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
