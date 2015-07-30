package in.gravitykerala.universityofcalicut.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import in.gravitykerala.universityofcalicut.OnlineApplicationActivity;
import in.gravitykerala.universityofcalicut.OnlineReg_epayment;
import in.gravitykerala.universityofcalicut.R;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class OnlineApplication extends Fragment {
    private static final String KEY_TITLE = "title";
    Button epayment;

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
        epayment = (Button) v.findViewById(R.id.button_epayment);
        epayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OnlineApplicationActivity.class);
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                intent.setData(Uri.parse("https://www.uoc.ac.in/gen_epay/pay1.php"));
                startActivity(intent);
//                WebView myWebView = (WebView) v.findViewById(R.id.webview);
//                myWebView.loadUrl("http://www.royalcet.in/about-us/");

            }
        });
//
        return v;
    }
}
