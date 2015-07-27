package in.gravitykerala.universityofcalicut.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andexert.library.RippleView;

import in.gravitykerala.universityofcalicut.NewNotificationActivity;
import in.gravitykerala.universityofcalicut.R;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class DistanceEducation extends Fragment {
    private static final String KEY_TITLE = "title";
    RippleView notification, onlineidcard, course, contact_class, affltd_clgs, study_material, qbank;

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
        notification = (RippleView) v.findViewById(R.id.notification_layout);
        onlineidcard = (RippleView) v.findViewById(R.id.online_idcard);
        course = (RippleView) v.findViewById(R.id.courses);
        contact_class = (RippleView) v.findViewById(R.id.contact_class);
        affltd_clgs = (RippleView) v.findViewById(R.id.affil_clgs);
        study_material = (RippleView) v.findViewById(R.id.stdy_materials);
        qbank = (RippleView) v.findViewById(R.id.qustn_bank);
//        notification.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i6 = new Intent(getActivity(), NewNotificationActivity.class);
//                i6.putExtra(NewNotificationActivity.KEY_NOTIFICATION_TYPE, NewNotificationActivity.NOTIFICATION_DISTANCE_NOTIFICATION);
//
//                startActivity(i6);
//            }
//        });
        notification.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
//                Log.d("Sample", "Ripple completed");
                Intent i6 = new Intent(getActivity(), NewNotificationActivity.class);
                i6.putExtra(NewNotificationActivity.KEY_NOTIFICATION_TYPE, NewNotificationActivity.NOTIFICATION_DISTANCE_NOTIFICATION);

                startActivity(i6);
            }

        });


//        onlineidcard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                intent.setData(Uri.parse("http://202.88.252.18/distance/sdeent_enrno_entry1.php"));
//                startActivity(intent);
//
//            }
//        });
        onlineidcard.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
//                Log.d("Sample", "Ripple completed");
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://202.88.252.18/distance/sdeent_enrno_entry1.php"));
                startActivity(intent);
            }

        });


//        course.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                intent.setData(Uri.parse("http://www.universityofcalicut.info/index.php?option=com_content&task=view&id=2152&Itemid=286"));
//                startActivity(intent);
//
//            }
//        });
        course.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
//                Log.d("Sample", "Ripple completed");
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.universityofcalicut.info/index.php?option=com_content&task=view&id=2152&Itemid=286"));
                startActivity(intent);
            }

        });


//        contact_class.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i7 = new Intent(getActivity(), NewNotificationActivity.class);
//                i7.putExtra(NewNotificationActivity.KEY_NOTIFICATION_TYPE, NewNotificationActivity.NOTIFICATION_DISTANCE_CONTACT_CLASS);
//                startActivity(i7);
//
//            }
//        });
        contact_class.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
//                Log.d("Sample", "Ripple completed");
                Intent i7 = new Intent(getActivity(), NewNotificationActivity.class);
                i7.putExtra(NewNotificationActivity.KEY_NOTIFICATION_TYPE, NewNotificationActivity.NOTIFICATION_DISTANCE_CONTACT_CLASS);
                startActivity(i7);
            }

        });


//        affltd_clgs.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                intent.setData(Uri.parse("http://www.universityofcalicut.info/SDE/councelling_centres/inside_kerala.pdf"));
//                startActivity(intent);
//
//            }
//        });


        affltd_clgs.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
//                Log.d("Sample", "Ripple completed");
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.universityofcalicut.info/SDE/councelling_centres/inside_kerala.pdf"));
                startActivity(intent);

            }

        });


//        study_material.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i8 = new Intent(getActivity(), NewNotificationActivity.class);
//                i8.putExtra(NewNotificationActivity.KEY_NOTIFICATION_TYPE, NewNotificationActivity.NOTIFICATION_DISTANCE_STUDY_MATERIAL);
//                startActivity(i8);
//
//            }
//        });


        study_material.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
//                Log.d("Sample", "Ripple completed");
                Intent i8 = new Intent(getActivity(), NewNotificationActivity.class);
                i8.putExtra(NewNotificationActivity.KEY_NOTIFICATION_TYPE, NewNotificationActivity.NOTIFICATION_DISTANCE_STUDY_MATERIAL);
                startActivity(i8);

            }

        });


//        qbank.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i9 = new Intent(getActivity(), NewNotificationActivity.class);
//                i9.putExtra(NewNotificationActivity.KEY_NOTIFICATION_TYPE, NewNotificationActivity.NOTIFICATION_DISTANCE_QUESTION_BANK);
//                startActivity(i9);
//            }
//        });
        qbank.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
//                Log.d("Sample", "Ripple completed");
                Intent i9 = new Intent(getActivity(), NewNotificationActivity.class);
                i9.putExtra(NewNotificationActivity.KEY_NOTIFICATION_TYPE, NewNotificationActivity.NOTIFICATION_DISTANCE_QUESTION_BANK);
                startActivity(i9);
            }

        });


        return v;
    }
}
