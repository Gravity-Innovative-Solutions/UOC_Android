package in.gravitykerala.universityofcalicut.Fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import in.gravitykerala.universityofcalicut.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    Timer timer;
    Handler mHandler;
    OneShotTask mUpdateResults;
    private View v;
    public int currentimageindex = 0;
    TimerTask task;
    ImageView slidingimage;
    private int[] IMAGE_IDS = {
            R.drawable.banner_one, R.drawable.banner_two, R.drawable.banner_three, R.drawable.banner_four

    };


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        timer.cancel();
        timer.purge();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        mHandler = new Handler();

        mUpdateResults = new OneShotTask(v);
        int delay = 1000; // delay for 1 sec.

        int period = 4000; // repeat every 4 sec.

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            //
            public void run() {

                mHandler.post(mUpdateResults);


            }

        }, delay, period);


        return v;

    }

    private void AnimateandSlideShow(View v) {


        slidingimage = (ImageView) v.findViewById(R.id.ImageView3_Left);
        slidingimage.setImageResource(IMAGE_IDS[currentimageindex % IMAGE_IDS.length]);

        currentimageindex++;

        try {
            Animation rotateimage = AnimationUtils.loadAnimation(this.getActivity().getApplicationContext(), R.anim.fade_in);


            slidingimage.startAnimation(rotateimage);
        } catch (NullPointerException e) {
            Log.d("Error", "Rotate?Image Not in view NullpointerException");
            e.printStackTrace();
        }


    }


    class OneShotTask implements Runnable {
        View v;

        OneShotTask(View vv) {
            v = vv;
        }

        public void run() {
            AnimateandSlideShow(v);
        }
    }


}
