package in.gravitykerala.universityofcalicut.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.gravitykerala.universityofcalicut.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DemoOne extends Fragment {


    public DemoOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_demo_one, container, false);
    }


}
