package in.gravitykerala.universityofcalicut.Fragment;


import android.content.Intent;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.andexert.library.RippleView;

import in.gravitykerala.universityofcalicut.Authorities;
import in.gravitykerala.universityofcalicut.NewNotificationActivity;
import in.gravitykerala.universityofcalicut.QuestionPaperActivity;
import in.gravitykerala.universityofcalicut.R;
import in.gravitykerala.universityofcalicut.RegularSyllabusActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class PareekshaBhavanFragment extends Fragment {
    private View v;
    ImageView fee;
    LinearLayout authorities, online_payment, online_registration, acdmc_calndr;
    RippleView authorities_ripple, online_pay_ripple, online_reg_ripple, calandar_ripple;


    public PareekshaBhavanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pareeksha_bhavan, container, false);
        ShapeDrawable drawable = new ShapeDrawable(new OvalShape());
//        fee = (ImageView) v.findViewById(R.id.imageView_feestructure);
        acdmc_calndr = (LinearLayout) v.findViewById(R.id.layout_calendar);
        authorities = (LinearLayout) v.findViewById(R.id.authorities);
        online_payment = (LinearLayout) v.findViewById(R.id.online_payment);
        online_registration = (LinearLayout) v.findViewById(R.id.online_reg);
        authorities_ripple = (RippleView) v.findViewById(R.id.authorities_ripple);
        online_pay_ripple = (RippleView) v.findViewById(R.id.online_pay_ripple);
        online_reg_ripple = (RippleView) v.findViewById(R.id.online_reg_ripple);
        calandar_ripple = (RippleView) v.findViewById(R.id.calandar_ripple);
//        online_registration.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                intent.setData(Uri.parse("http://202.88.252.18/CuPbOnline/online_portal/"));
//                startActivity(intent);
//
//            }
//        });
        online_reg_ripple.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://202.88.252.18/CuPbOnline/online_portal/"));
                startActivity(intent);

            }

        });


//        online_payment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                intent.setData(Uri.parse("https://www.uoc.ac.in/"));
//                startActivity(intent);
//
//            }
//        });
        online_pay_ripple.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.uoc.ac.in/"));
                startActivity(intent);

            }

        });


//        authorities.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i1 = new Intent(getActivity(), Authorities.class);
//                startActivity(i1);
//
//            }
//        });
        authorities_ripple.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Intent i1 = new Intent(getActivity(), Authorities.class);
                startActivity(i1);

            }

        });


        drawable.getPaint().setColor(getResources().getColor(R.color.accent));
        // ((FloatingActionButton) findViewById(R.id.setter_drawable)).setIconDrawable(drawable);
//        fee.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        acdmc_calndr.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                intent.setData(Uri.parse("http://www.universityofcalicut.info/news/academic_calender_2015-16_29april2015.pdf"));
//                startActivity(intent);
//            }
//        });

        calandar_ripple.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.universityofcalicut.info/news/academic_calender_2015-16_29april2015.pdf"));
                startActivity(intent);

            }

        });


        v.findViewById(R.id.a).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QuestionPaperActivity.class);
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                intent.setData(Uri.parse("http://www.universityofcalicut.info/news/revised_feestructure_on29june2015.pdf"));
                startActivity(intent);

            }
        });
        v.findViewById(R.id.b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getActivity(), RegularSyllabusActivity.class);
                startActivity(i1);
            }
        });
        v.findViewById(R.id.c).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(getActivity(), NewNotificationActivity.class);
                i4.putExtra(NewNotificationActivity.KEY_NOTIFICATION_TYPE, NewNotificationActivity.NOTIFICATION_EXAM_NOTIFICATIONS);
                startActivity(i4);
            }
        });
        v.findViewById(R.id.d).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(getActivity(), NewNotificationActivity.class);
                i4.putExtra(NewNotificationActivity.KEY_NOTIFICATION_TYPE, NewNotificationActivity.NOTIFICATION_EXAM_RESULT);
                startActivity(i4);

            }
        });
        v.findViewById(R.id.e).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5 = new Intent(getActivity(), NewNotificationActivity.class);
                i5.putExtra(NewNotificationActivity.KEY_NOTIFICATION_TYPE, NewNotificationActivity.NOTIFICATION_EXAM_TIMETABLE);
                startActivity(i5);

            }
        });


        return v;
    }
//    private void applyPalette(Palette palette) {
//        int primaryDark = getResources().getColor(R.color.primary_dark);
//        int primary = getResources().getColor(R.color.primary);
//
//        updateBackground((FloatingActionButton) v.findViewById(R.id.fab), palette);
//
//    }
//    private void updateBackground(FloatingActionButton fab, Palette palette) {
//        int lightVibrantColor = palette.getLightVibrantColor(getResources().getColor(android.R.color.white));
//        int vibrantColor = palette.getVibrantColor(getResources().getColor(R.color.accent));
//
//        fab.setRippleColor(lightVibrantColor);
//        fab.setBackgroundTintList(ColorStateList.valueOf(vibrantColor));
//    }

}
