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

import in.gravitykerala.universityofcalicut.Authorities;
import in.gravitykerala.universityofcalicut.R;
import in.gravitykerala.universityofcalicut.Syllabus;

/**
 * A simple {@link Fragment} subclass.
 */
public class PareekshaBhavanFragment extends Fragment {
    private View v;
    ImageView fee, acdmc_calndr;


    public PareekshaBhavanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pareeksha_bhavan, container, false);
        ShapeDrawable drawable = new ShapeDrawable(new OvalShape());
        fee = (ImageView) v.findViewById(R.id.imageView_feestructure);
        acdmc_calndr = (ImageView) v.findViewById(R.id.imageView_calendar);
        drawable.getPaint().setColor(getResources().getColor(R.color.accent));
        // ((FloatingActionButton) findViewById(R.id.setter_drawable)).setIconDrawable(drawable);
        fee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.universityofcalicut.info/news/revised_feestructure_on29june2015.pdf"));
                startActivity(intent);
            }
        });
        acdmc_calndr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                Intent i1 = new Intent(getActivity(), Authorities.class);
                startActivity(i1);
            }
        });
        v.findViewById(R.id.b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getActivity(), Syllabus.class);
                startActivity(i1);
            }
        });
        v.findViewById(R.id.c).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i1 = new Intent(getActivity(), Notification.class);
//                startActivity(i1);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.universityofcalicut.info/index.php?option=com_content&task=view&id=744&Itemid=324"));
                startActivity(intent);
            }
        });
        v.findViewById(R.id.d).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i1 = new Intent(getActivity(), Result.class);
//                startActivity(i1);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://202.88.252.21/CuPbhavan/curesults.php"));
                startActivity(intent);
            }
        });
        v.findViewById(R.id.e).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i1 = new Intent(getActivity(), TimeTable.class);
//                startActivity(i1);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.universityofcalicut.info/index.php?option=com_content&task=view&id=745&Itemid=325"));
                startActivity(intent);
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
