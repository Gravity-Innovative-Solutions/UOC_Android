package in.gravitykerala.universityofcalicut;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread timer = new Thread() {
            public void run() {
                try {

                    sleep(3000);
                    //copyFileOrDir(DOC_ASSET_DIR);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent in;
                    in = new Intent(Splash.this, Registration.class);
//
//                    if ("none".equals(selectedCourse)) {
//                        //Stream not selected
//                        in = new Intent(Splash.this, Selection.class);
//                    } else {
//                        //Stream selected previously
//                        in = new Intent(Splash.this, FragmentManagerActivity.class);
//                    }
//                    in = new Intent(Splash.this, Selection_Activity_main.class);
                    startActivity(in);


                }
            }

        };
        timer.start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
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

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        //ourSong.release();
        finish();
    }
}
