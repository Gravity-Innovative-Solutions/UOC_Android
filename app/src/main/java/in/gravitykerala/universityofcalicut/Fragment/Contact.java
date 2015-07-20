package in.gravitykerala.universityofcalicut.Fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import in.gravitykerala.universityofcalicut.AcademicSection;
import in.gravitykerala.universityofcalicut.AdministrativeNumbers;
import in.gravitykerala.universityofcalicut.Helpline;
import in.gravitykerala.universityofcalicut.R;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class Contact extends Fragment {
    private static final String KEY_TITLE = "title";
    ImageView map;
    LinearLayout student_help, administrative_nos, academic_section;


    public Contact() {
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
        View v = inflater.inflate(R.layout.fragment_contact, container, false);
        map = (ImageView) v.findViewById(R.id.imageView_map);
        student_help = (LinearLayout) v.findViewById(R.id.student_help);
        administrative_nos = (LinearLayout) v.findViewById(R.id.administrative_nos);
        academic_section = (LinearLayout) v.findViewById(R.id.academic_section);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=10.760719,76.230712(Malabar College of Engineering and Technology,Deshamangalam)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
//

            }
        });
        student_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Helpline.class);
                startActivity(i);
            }
        });
        administrative_nos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), AdministrativeNumbers.class);
                startActivity(i);

            }
        });
        academic_section.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), AcademicSection.class);
                startActivity(i);

            }
        });

////                Intent intent = new Intent();
////                intent.setAction(Intent.ACTION_VIEW);
////                intent.addCategory(Intent.CATEGORY_BROWSABLE);
////                intent.setData(Uri.parse("http://www.cuonline.ac.in/"));
////        startActivity(intent);
//                  WebView myWebView = (WebView) v.findViewById(R.id.webview);
//                  myWebView.loadUrl("http://www.cuonline.ac.in/");


        return v;
    }

}
