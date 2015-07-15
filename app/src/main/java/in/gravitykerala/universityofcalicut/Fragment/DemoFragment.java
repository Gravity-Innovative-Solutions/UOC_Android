package in.gravitykerala.universityofcalicut.Fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import in.gravitykerala.universityofcalicut.R;
import in.gravitykerala.universityofcalicut.VC;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class DemoFragment extends Fragment {
    private static final String KEY_TITLE = "title";
    LinearLayout news, uni_orders, diary, vc;


    public DemoFragment() {
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
        View v = inflater.inflate(R.layout.fragment_about, container, false);
        vc = (LinearLayout) v.findViewById(R.id.vc);
        news = (LinearLayout) v.findViewById(R.id.news);
        uni_orders = (LinearLayout) v.findViewById(R.id.uni_orders);
        diary = (LinearLayout) v.findViewById(R.id.diary);
        vc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), VC.class);
                startActivity(i);

            }
        });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.cuonline.ac.in/?cat=5"));
                startActivity(intent);
            }
        });
        uni_orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.universityofcalicut.info/index.php?option=com_content&task=view&id=1020&Itemid=391"));
                startActivity(intent);
            }
        });
        uni_orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.universityofcalicut.info/news/diary_2015_revised_det_29jan2015.pdf"));
                startActivity(intent);
            }
        });
        return v;

    }
}
