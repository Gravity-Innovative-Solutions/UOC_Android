package in.gravitykerala.universityofcalicut.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import in.gravitykerala.universityofcalicut.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Test_Mphill extends Fragment {


    public Test_Mphill() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_test__mphill, container, false);
        WebView myWebView = (WebView) v.findViewById(R.id.webview);
        myWebView.loadUrl("http://www.universityofcalicut.info/dor/");
        return v;
    }


}
