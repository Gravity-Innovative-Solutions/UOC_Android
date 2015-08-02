package in.gravitykerala.universityofcalicut;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class AcademicSection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_section);
        TextView myph_academic = (TextView) findViewById(R.id.textView122);
        TextView myph_academic1 = (TextView) findViewById(R.id.textView124);
        TextView myph_academic2 = (TextView) findViewById(R.id.textView126);
        TextView myph_academic3 = (TextView) findViewById(R.id.textView128);
        TextView myph_academic4 = (TextView) findViewById(R.id.textView130);
        TextView myph_academic5 = (TextView) findViewById(R.id.textView132);
        TextView myph_academic6 = (TextView) findViewById(R.id.textView134);
        TextView myph_academic7 = (TextView) findViewById(R.id.textView136);
        TextView myph_academic8 = (TextView) findViewById(R.id.textView138);
        TextView myph_academic9 = (TextView) findViewById(R.id.textView140);
        TextView myph_academic10 = (TextView) findViewById(R.id.textView142);
        TextView myph_academic11 = (TextView) findViewById(R.id.textView144);
        TextView myph_academic12 = (TextView) findViewById(R.id.textView146);
        TextView myph_academic13 = (TextView) findViewById(R.id.textView148);
        TextView myph_academic14 = (TextView) findViewById(R.id.textView150);
        TextView myph_academic15 = (TextView) findViewById(R.id.textView152);
        TextView myph_academic16 = (TextView) findViewById(R.id.textView154);
        TextView myph_academic17 = (TextView) findViewById(R.id.textView156);
        TextView myph_academic18 = (TextView) findViewById(R.id.textView158);
        TextView myph_academic19 = (TextView) findViewById(R.id.textView160);
        TextView myph_academic20 = (TextView) findViewById(R.id.textView162);
        TextView myph_academic21 = (TextView) findViewById(R.id.textView164);
        TextView myph_academic22 = (TextView) findViewById(R.id.textView166);
        TextView myph_academic23 = (TextView) findViewById(R.id.textView168);
        TextView myph_academic24 = (TextView) findViewById(R.id.textView170);
        TextView myph_academic25 = (TextView) findViewById(R.id.textView172);
        TextView myph_academic26 = (TextView) findViewById(R.id.textView174);
        TextView myph_academic27 = (TextView) findViewById(R.id.textView176);
        TextView myph_academic28 = (TextView) findViewById(R.id.textView178);
        TextView myph_academic29 = (TextView) findViewById(R.id.textView180);
        TextView myph_academic30 = (TextView) findViewById(R.id.textView182);
        TextView myph_academic31 = (TextView) findViewById(R.id.textView184);
        TextView myph_academic32 = (TextView) findViewById(R.id.textView186);
        TextView myph_academic33 = (TextView) findViewById(R.id.textView188);
        TextView myph_academic34 = (TextView) findViewById(R.id.textView190);
        TextView myph_academic35 = (TextView) findViewById(R.id.textView192);
        TextView myph_academic36 = (TextView) findViewById(R.id.textView194);
        TextView myph_academic37 = (TextView) findViewById(R.id.textView196);
        TextView myph_academic38 = (TextView) findViewById(R.id.textView200);
        TextView myph_academic39 = (TextView) findViewById(R.id.textView202);
        TextView myph_academic40 = (TextView) findViewById(R.id.textView204);
        TextView myph_academic41 = (TextView) findViewById(R.id.textView207);
        TextView myph_academic42 = (TextView) findViewById(R.id.textView209);
        TextView myph_academic43 = (TextView) findViewById(R.id.textView211);
        TextView myph_academic44 = (TextView) findViewById(R.id.textView213);
        TextView myph_academic45 = (TextView) findViewById(R.id.textView215);
        TextView myph_academic46 = (TextView) findViewById(R.id.textView217);
        TextView myph_academic47 = (TextView) findViewById(R.id.textView219);
        TextView myph_academic48 = (TextView) findViewById(R.id.textView221);
        TextView myph_academic49 = (TextView) findViewById(R.id.textView223);
        TextView myph_academic50 = (TextView) findViewById(R.id.textView225);
        TextView myph_academic51 = (TextView) findViewById(R.id.textView227);
        TextView myph_academic52 = (TextView) findViewById(R.id.textView229);
        TextView myph_academic53 = (TextView) findViewById(R.id.textView231);
        TextView myph_academic54 = (TextView) findViewById(R.id.textView233);
        TextView myph_academic55 = (TextView) findViewById(R.id.textView235);
        TextView myph_academic56 = (TextView) findViewById(R.id.textView237);
        TextView myph_academic57 = (TextView) findViewById(R.id.textView239);
        TextView myph_academic58 = (TextView) findViewById(R.id.textView241);
        TextView myph_academic59 = (TextView) findViewById(R.id.textView243);
        TextView myph_academic60 = (TextView) findViewById(R.id.textView245);
        TextView myph_academic61 = (TextView) findViewById(R.id.textView247);
        TextView myph_academic62 = (TextView) findViewById(R.id.textView249);
        TextView myph_academic63 = (TextView) findViewById(R.id.textView251);
        TextView myph_academic64 = (TextView) findViewById(R.id.textView253);
        TextView myph_academic65 = (TextView) findViewById(R.id.textView255);
        TextView myph_academic66 = (TextView) findViewById(R.id.textView257);
//        TextView myph_academic67 = (TextView) findViewById(R.id.textView258);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        myph_academic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7200"));
                startActivity(callIntent);
            }
        });
        myph_academic1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7202"));
                startActivity(callIntent);
            }
        });
        myph_academic2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7239"));
                startActivity(callIntent);
            }
        });
        myph_academic3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7231"));
                startActivity(callIntent);
            }
        });
        myph_academic4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7315"));
                startActivity(callIntent);
            }
        });
        myph_academic5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7315"));
                startActivity(callIntent);
            }
        });
        myph_academic6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7210"));
                startActivity(callIntent);
            }
        });
        myph_academic7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7213"));
                startActivity(callIntent);
            }
        });
        myph_academic8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7283"));
                startActivity(callIntent);
            }
        });
        myph_academic9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7282"));
                startActivity(callIntent);
            }
        });
        myph_academic10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7284"));
                startActivity(callIntent);
            }
        });
        myph_academic11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7211"));
                startActivity(callIntent);
            }
        });
        myph_academic12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7269"));
                startActivity(callIntent);
            }
        });
        myph_academic13.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7272"));
                startActivity(callIntent);
            }
        });
        myph_academic14.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7275"));
                startActivity(callIntent);
            }
        });
        myph_academic15.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7273"));
                startActivity(callIntent);
            }
        });
        myph_academic16.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7274"));
                startActivity(callIntent);
            }
        });
        myph_academic17.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7276"));
                startActivity(callIntent);
            }
        });
        myph_academic18.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7277"));
                startActivity(callIntent);
            }
        });
        myph_academic19.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7294"));
                startActivity(callIntent);
            }
        });
        myph_academic20.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7280"));
                startActivity(callIntent);
            }
        });
        myph_academic21.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7293"));
                startActivity(callIntent);
            }
        });
        myph_academic22.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7214"));
                startActivity(callIntent);
            }
        });
        myph_academic23.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7431"));
                startActivity(callIntent);
            }
        });
        myph_academic24.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7291"));
                startActivity(callIntent);
            }
        });
        myph_academic25.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7249"));
                startActivity(callIntent);
            }
        });
        myph_academic26.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7296"));
                startActivity(callIntent);
            }
        });
        myph_academic27.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7298"));
                startActivity(callIntent);
            }
        });
        myph_academic28.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7297"));
                startActivity(callIntent);
            }
        });
        myph_academic29.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7295"));
                startActivity(callIntent);
            }
        });
        myph_academic30.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7299"));
                startActivity(callIntent);
            }
        });
        myph_academic31.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7234"));
                startActivity(callIntent);
            }
        });
        myph_academic32.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7478"));
                startActivity(callIntent);
            }
        });
        myph_academic33.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7471"));
                startActivity(callIntent);
            }
        });
        myph_academic34.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7472"));
                startActivity(callIntent);
            }
        });
        myph_academic35.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7483"));
                startActivity(callIntent);
            }
        });
        myph_academic36.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7479"));
                startActivity(callIntent);
            }
        });
        myph_academic37.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7401"));
                startActivity(callIntent);
            }
        });
        myph_academic38.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7482"));
                startActivity(callIntent);
            }
        });
        myph_academic39.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7223"));
                startActivity(callIntent);
            }
        });
        myph_academic40.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7224"));
                startActivity(callIntent);
            }
        });
        myph_academic41.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7436"));
                startActivity(callIntent);
            }
        });
        myph_academic42.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7225"));
                startActivity(callIntent);
            }
        });
        myph_academic43.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7462"));
                startActivity(callIntent);
            }
        });
        myph_academic44.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7437"));
                startActivity(callIntent);
            }
        });
        myph_academic45.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7459"));
                startActivity(callIntent);
            }
        });
        myph_academic46.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7458"));
                startActivity(callIntent);
            }
        });
        myph_academic47.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7442"));
                startActivity(callIntent);
            }
        });
        myph_academic48.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7438"));
                startActivity(callIntent);
            }
        });
        myph_academic49.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7437"));
                startActivity(callIntent);
            }
        });
        myph_academic50.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7433"));
                startActivity(callIntent);
            }
        });
        myph_academic51.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7435"));
                startActivity(callIntent);
            }
        });
        myph_academic52.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7434"));
                startActivity(callIntent);
            }
        });
        myph_academic53.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7229"));
                startActivity(callIntent);
            }
        });
        myph_academic54.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7460"));
                startActivity(callIntent);
            }
        });
        myph_academic55.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7449"));
                startActivity(callIntent);
            }
        });
        myph_academic56.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7457"));
                startActivity(callIntent);
            }
        });
        myph_academic57.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 04942407261"));
                startActivity(callIntent);
            }
        });
        myph_academic58.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7438"));
                startActivity(callIntent);
            }
        });
        myph_academic59.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7437"));
                startActivity(callIntent);
            }
        });
        myph_academic60.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7433"));
                startActivity(callIntent);
            }
        });
        myph_academic61.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7435"));
                startActivity(callIntent);
            }
        });
        myph_academic62.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7434"));
                startActivity(callIntent);
            }
        });
        myph_academic63.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7229"));
                startActivity(callIntent);
            }
        });
        myph_academic64.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7460"));
                startActivity(callIntent);
            }
        });
        myph_academic65.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7449"));
                startActivity(callIntent);
            }
        });
        myph_academic66.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel: 0494-240-7457"));
                startActivity(callIntent);
            }
        });
//        myph_academic67.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//
//                Intent callIntent = new Intent(Intent.ACTION_CALL);
//                callIntent.setData(Uri.parse("tel: 04942407261"));
//                startActivity(callIntent);
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_academic_section, menu);
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
