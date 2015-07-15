package in.gravitykerala.universityofcalicut;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import at.markushi.ui.RevealColorView;
import in.gravitykerala.universityofcalicut.Fragment.TestFragment;
import in.gravitykerala.universityofcalicut.Fragment.Test_Mphill;
import in.gravitykerala.universityofcalicut.Fragment.Test_PG_fragment;


public class AboutActivity extends AppCompatActivity {
    private RevealColorView revealColorView;
    private View selectedView;
    private int backgroundColor;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        revealColorView = (RevealColorView) findViewById(R.id.reveal);
        backgroundColor = Color.parseColor("#212121");
//        tv=(TextView)findViewById.tv);

        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int color = getColor(v);
                final Point p = getLocationInView(revealColorView, v);

                if (selectedView == v) {
                    revealColorView.hide(p.x, p.y, backgroundColor, 0, 300, null);
                    selectedView = null;

                } else {
                    revealColorView.reveal(p.x, p.y, color, v.getHeight() / 2, 340, null);
                    selectedView = v;
                }
                Fragment f = new TestFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_lt, f).commit();


            }
        });
        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int color = getColor(v);
                final Point p = getLocationInView(revealColorView, v);

                if (selectedView == v) {
                    revealColorView.hide(p.x, p.y, backgroundColor, 0, 300, null);
                    selectedView = null;

                } else {
                    revealColorView.reveal(p.x, p.y, color, v.getHeight() / 2, 340, null);
                    selectedView = v;
                }
                Fragment f = new Test_PG_fragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_lt, f).commit();


            }
        });
        findViewById(R.id.btn_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int color = getColor(v);
                final Point p = getLocationInView(revealColorView, v);

                if (selectedView == v) {
                    revealColorView.hide(p.x, p.y, backgroundColor, 0, 300, null);
                    selectedView = null;
                } else {
                    revealColorView.reveal(p.x, p.y, color, v.getHeight() / 2, 340, null);
                    selectedView = v;
                    Fragment f = new Test_Mphill();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_lt, f).commit();
                }


            }
        });
        findViewById(R.id.btn_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int color = getColor(v);
                final Point p = getLocationInView(revealColorView, v);

                if (selectedView == v) {
                    revealColorView.hide(p.x, p.y, backgroundColor, 0, 300, null);
                    selectedView = null;
                } else {
                    revealColorView.reveal(p.x, p.y, color, v.getHeight() / 2, 340, null);
                    selectedView = v;
                }
                Fragment f = new Test_Mphill();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_lt, f).commit();

            }
        });
    }

    //    @Override
//    public void onClick(View v) {
//        final int color = getColor(v);
//        final Point p = getLocationInView(revealColorView, v);
//
//        if (selectedView == v) {
//            revealColorView.hide(p.x, p.y, backgroundColor, 0, 300, null);
//            selectedView = null;
//        } else {
//            revealColorView.reveal(p.x, p.y, color, v.getHeight() / 2, 340, null);
//            selectedView = v;
//        }
//    }
    private Point getLocationInView(View src, View target) {
        final int[] l0 = new int[2];
        src.getLocationOnScreen(l0);

        final int[] l1 = new int[2];
        target.getLocationOnScreen(l1);

        l1[0] = l1[0] - l0[0] + target.getWidth() / 2;
        l1[1] = l1[1] - l0[1] + target.getHeight() / 2;

        return new Point(l1[0], l1[1]);
    }

    private int getColor(View view) {
        return Color.parseColor((String) view.getTag());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about, menu);
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
