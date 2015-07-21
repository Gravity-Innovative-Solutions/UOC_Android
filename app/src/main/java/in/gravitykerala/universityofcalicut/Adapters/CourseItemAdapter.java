package in.gravitykerala.universityofcalicut.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.microsoft.windowsazure.notifications.NotificationsManager;

import in.gravitykerala.universityofcalicut.GravitySupport;
import in.gravitykerala.universityofcalicut.HomeDrawer;
import in.gravitykerala.universityofcalicut.Models.CourseItemDTO;
import in.gravitykerala.universityofcalicut.NotificationActivity;
import in.gravitykerala.universityofcalicut.PushNotificationHandler;
import in.gravitykerala.universityofcalicut.R;

/**
 * Adapter to bind a ToDoItem List to a view
 */
public class CourseItemAdapter extends ArrayAdapter<CourseItemDTO> implements GravitySupport {


    /**
     * Adapter context
     */
    Context mContext;
    SharedPreferences prefs;

    /**
     * Adapter View layout
     */
    int mLayoutResourceId;

    public CourseItemAdapter(Context context, int layoutResourceId) {
        super(context, layoutResourceId);

        mContext = context;
        mLayoutResourceId = layoutResourceId;

        prefs = mContext.getSharedPreferences(KEY_PREFERENCE_ID, Context.MODE_APPEND);

    }

    /**
     * Returns the view for a specific item on the list
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        final CourseItemDTO currentItem = getItem(position);

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

        row.setTag(currentItem);
        final TextView courseName = (TextView) row.findViewById(R.id.course_name);

        courseName.setText(currentItem.courseName);

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("PushNotification:", "registering");
                NotificationsManager.handleNotifications(mContext, NotificationActivity.SENDER_ID, PushNotificationHandler.class);
                Log.d("PushNotification:", "registered");

                CourseItemDTO clickedCourse = (CourseItemDTO) v.getTag();
                Log.d("CourseRowClicked:", "Course:" + clickedCourse.courseName + " Id:" + clickedCourse.courseId);
                prefs.edit().putString(KEY_SELECTED_COURSE_ID, clickedCourse.courseId).apply();

                Intent mainIntent = new Intent(mContext, HomeDrawer.class);
                mContext.startActivity(mainIntent);
            }
        });


//        checkBox.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//                if (checkBox.isChecked()) {
//                    checkBox.setEnabled(false);
//                    if (mContext instanceof NotificationActivity) {
//                        NotificationActivity activity = (NotificationActivity) mContext;
//                        activity.checkItem(currentItem);
//                    }
//                }
//            }
//        });

        return row;
    }

}