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


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class DistanceEducation extends Fragment {
    private static final String KEY_TITLE = "title";
    LinearLayout notification, onlineidcard, course, contact_class, affltd_clgs, study_material, qbank;

    public DistanceEducation() {
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
        View v = inflater.inflate(R.layout.fragment_distance_education, container, false);
        notification = (LinearLayout) v.findViewById(R.id.notification_layout);
        onlineidcard = (LinearLayout) v.findViewById(R.id.online_idcard);
        course = (LinearLayout) v.findViewById(R.id.courses);
        contact_class = (LinearLayout) v.findViewById(R.id.contact_class);
        affltd_clgs = (LinearLayout) v.findViewById(R.id.affil_clgs);
        study_material = (LinearLayout) v.findViewById(R.id.stdy_materials);
        qbank = (LinearLayout) v.findViewById(R.id.qustn_bank);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.universityofcalicut.info/index.php?option=com_content&task=view&id=1567&Itemid=404"));
                startActivity(intent);
            }
        });
        onlineidcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://202.88.252.18/distance/sdeent_enrno_entry1.php"));
                startActivity(intent);

            }
        });
        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.universityofcalicut.info/index.php?option=com_content&task=view&id=2152&Itemid=286"));
                startActivity(intent);

            }
        });
        contact_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.universityofcalicut.info/index.php?option=com_content&task=view&id=368&Itemid=289"));
                startActivity(intent);

            }
        });
        affltd_clgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.universityofcalicut.info/SDE/councelling_centres/inside_kerala.pdf"));
                startActivity(intent);

            }
        });
        study_material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.universityofcalicut.info/index.php?option=com_content&task=view&id=2366&Itemid=385"));
                startActivity(intent);

            }
        });
        qbank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.universityofcalicut.info/index.php?option=com_content&task=view&id=1081&Itemid=395"));
                startActivity(intent);

            }
        });

        return v;
    }
}
