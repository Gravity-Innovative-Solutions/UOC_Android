package in.gravitykerala.universityofcalicut.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import in.gravitykerala.universityofcalicut.R;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class OnlineApplication extends Fragment {
    private static final String KEY_TITLE = "title";

    public OnlineApplication() {
        // Required empty public constructor
    }

    public static DemoFragment newInstance(String title) {
        DemoFragment f = new DemoFragment();

        Bundle args = new Bundle();

        args.putString(KEY_TITLE, title);
        f.setArguments(args);

        return (f);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // don't look at this layout it's just a listView to show how to handle the keyboard
        View v = inflater.inflate(R.layout.fragment_online_application, container, false);
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_VIEW);
//        intent.addCategory(Intent.CATEGORY_BROWSABLE);
//        intent.setData(Uri.parse("http://202.88.252.18/CuPbOnline/online_portal/registration.php#"));
//        startActivity(intent);
        WebView myWebView = (WebView) v.findViewById(R.id.webview1);
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.loadUrl("https://www.uoc.ac.in/gen_epay/pay1.php");
        return v;
    }
}
