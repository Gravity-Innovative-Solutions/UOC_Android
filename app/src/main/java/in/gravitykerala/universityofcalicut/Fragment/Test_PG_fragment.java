package in.gravitykerala.universityofcalicut.Fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import in.gravitykerala.universityofcalicut.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Test_PG_fragment extends Fragment {
    Button withen, without, pros, reg, admi;


    public Test_PG_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_test__pg_fragment, container, false);
//        WebView myWebView = (WebView) v.findViewById(R.id.webview);
//        myWebView.loadUrl("http://www.royalcet.in/about-us/");
        withen = (Button) v.findViewById(R.id.button_we);
        without = (Button) v.findViewById(R.id.button_wo);
        pros = (Button) v.findViewById(R.id.button_pros);
        reg = (Button) v.findViewById(R.id.button_reg);
        admi = (Button) v.findViewById(R.id.button_adm);
        withen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.cuonline.ac.in/?page_id=111&action=listCourses&course_type_id=2&has_ent=1"));
                startActivity(intent);
            }
        });
        without.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.cuonline.ac.in/?page_id=111&action=listCourses&course_type_id=2&has_ent=0"));
                startActivity(intent);
            }
        });
        pros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.cuonline.ac.in/?page_id=111&action=listCourses&course_type_id=2&has_ent=1#"));
                startActivity(intent);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.cuonline.ac.in/?page_id=266"));
                startActivity(intent);
            }
        });
//        admi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                intent.setData(Uri.parse("http://www.cuonline.ac.in/ugcap2015/capserver1/"));
//                startActivity(intent);
//            }
//        });
        return v;
    }


}
