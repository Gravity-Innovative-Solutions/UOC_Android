package in.gravitykerala.universityofcalicut.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import in.gravitykerala.universityofcalicut.R;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class AdmissionPortal extends Fragment {
    private static final String KEY_TITLE = "title";
    Button epayment;

    public AdmissionPortal() {
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
        View v = inflater.inflate(R.layout.fragment_admission_portal, container, false);

////                Intent intent = new Intent();
////                intent.setAction(Intent.ACTION_VIEW);
////                intent.addCategory(Intent.CATEGORY_BROWSABLE);
////                intent.setData(Uri.parse("http://www.cuonline.ac.in/"));
////        startActivity(intent);
//                  WebView myWebView = (WebView) v.findViewById(R.id.webview);
//                  myWebView.loadUrl("http://www.cuonline.ac.in/");


        WebView mainWebView = (WebView) v.findViewById(R.id.webview);

        WebSettings webSettings = mainWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mainWebView.setWebViewClient(new MyCustomWebViewClient());
        mainWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        mainWebView.loadUrl("http://gravitykerala.in/");


//
        return v;
    }

    private class MyCustomWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
