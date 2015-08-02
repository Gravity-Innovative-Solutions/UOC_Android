package in.gravitykerala.universityofcalicut;

/**
 * Created by Prakash on 6/5/2015.
 expect112@gmail.com
 */

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.microsoft.windowsazure.notifications.NotificationsHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class PushNotificationHandler extends NotificationsHandler implements GravitySupport {


    public static final int NOTIFICATION_ID = 1;
    NotificationCompat.Builder builder;
    Context ctx, currentContext;
    SharedPreferences prefs;
    private NotificationManager mNotificationManager;

    @Override
    public void onRegistered(Context context, final String gcmRegistrationId) {
        super.onRegistered(context, gcmRegistrationId);
        currentContext = context;

        new AsyncTask<Void, Void, Void>() {

            protected Void doInBackground(Void... params) {
                try {
//                    prefs = currentContext.getSharedPreferences(KEY_PREFERENCE_ID, Context.MODE_APPEND);
//                    String selectedCourse = prefs.getString(KEY_SELECTED_COURSE_ID, "none");

                    String[] tags = getSubscribedNotifications(currentContext);
                    for (String tag : tags) {
                        Log.d("IncludedTag:", tag);
                    }
                    NotificationActivity.mClient.getPush().register(gcmRegistrationId, tags);

                    return null;
                } catch (Exception e) {
                    // handle error
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    @Override
    public void onReceive(Context context, Bundle bundle) {
        ctx = context;
        String nhMessage = bundle.getString("message");
        String msgContent = bundle.getString("content");
        String notificationType = bundle.getString(KEY_NOTIFICATION_TYPE);

        sendNotification(nhMessage, msgContent, notificationType);
    }

    private void sendNotification(String msg, String content, String notificationType) {
        mNotificationManager = (NotificationManager)
                ctx.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent notificationIntent = new Intent(ctx, NewNotificationActivity.class);


        if (ID_NOTIFICATION_DISTANCE_CONTACT_CLASS.contentEquals(notificationType)) {
            notificationIntent.putExtra(NewNotificationActivity.KEY_NOTIFICATION_TYPE, NewNotificationActivity.NOTIFICATION_DISTANCE_CONTACT_CLASS);
        } else if (ID_NOTIFICATION_DISTANCE_NOTIFICATION.contentEquals(notificationType)) {
            notificationIntent.putExtra(NewNotificationActivity.KEY_NOTIFICATION_TYPE, NewNotificationActivity.NOTIFICATION_DISTANCE_NOTIFICATION);
        } else if (ID_NOTIFICATION_DISTANCE_QUESTION_BANK.contentEquals(notificationType)) {
            notificationIntent.putExtra(NewNotificationActivity.KEY_NOTIFICATION_TYPE, NewNotificationActivity.NOTIFICATION_DISTANCE_QUESTION_BANK);
        } else if (ID_NOTIFICATION_DISTANCE_STUDY_MATERIAL.contentEquals(notificationType)) {
            notificationIntent.putExtra(NewNotificationActivity.KEY_NOTIFICATION_TYPE, NewNotificationActivity.NOTIFICATION_DISTANCE_STUDY_MATERIAL);
        } else if (ID_NOTIFICATION_EXAM_NOTIFICATIONS.contentEquals(notificationType)) {
            notificationIntent.putExtra(NewNotificationActivity.KEY_NOTIFICATION_TYPE, NewNotificationActivity.NOTIFICATION_EXAM_NOTIFICATIONS);
        } else if (ID_NOTIFICATION_EXAM_RESULT.contentEquals(notificationType)) {
            notificationIntent.putExtra(NewNotificationActivity.KEY_NOTIFICATION_TYPE, NewNotificationActivity.NOTIFICATION_EXAM_RESULT);
        } else if (ID_NOTIFICATION_EXAM_TIMETABLE.contentEquals(notificationType)) {
            notificationIntent.putExtra(NewNotificationActivity.KEY_NOTIFICATION_TYPE, NewNotificationActivity.NOTIFICATION_EXAM_TIMETABLE);
        } else if (ID_NOTIFICATION_NEWS.contentEquals(notificationType)) {
            notificationIntent.putExtra(NewNotificationActivity.KEY_NOTIFICATION_TYPE, NewNotificationActivity.NOTIFICATION_NOTIFICATION_NEWS);
        } else if (ID_NOTIFICATION_ORDERS.contentEquals(notificationType)) {
            notificationIntent.putExtra(NewNotificationActivity.KEY_NOTIFICATION_TYPE, NewNotificationActivity.NOTIFICATION_NOTIFICATION_ORDERS);
        } else if (ID_NOTIFICATION_VC_DESK.contentEquals(notificationType)) {
            notificationIntent.putExtra(NewNotificationActivity.KEY_NOTIFICATION_TYPE, NewNotificationActivity.NOTIFICATION_VC_DESK);
        }

        PendingIntent contentIntent = PendingIntent.getActivity(ctx, 0,
                notificationIntent, 0);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(ctx)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("University")
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText(msg))
                        .setContentText(msg + ": \n" + content);

        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }

    String[] getSubscribedNotifications(Context context) {
        Set<String> subscribedNotiificationsList = new HashSet<String>();
        prefs = context.getSharedPreferences(KEY_PREFERENCE_ID, Context.MODE_APPEND);
        String selectedCourse = prefs.getString(KEY_SELECTED_COURSE_ID, "none");
        String selectedDepartment = prefs.getString(KEY_SELECTED_DEPARTMENT_ID, "none");
        if (prefs.getBoolean(KEY_EXAM_NOTIFICATION_NEEDED, false)) {
            if (!"none".equals(selectedCourse))
                subscribedNotiificationsList.add(TAG_COMMON_EXAM + selectedCourse);
            if (!"none".equals(selectedDepartment))
                subscribedNotiificationsList.add(TAG_COMMON_EXAM + selectedDepartment);

            subscribedNotiificationsList.add(TAG_NOTIFICATION_EXAM_NOTIFICATIONS);
            subscribedNotiificationsList.add(TAG_NOTIFICATION_EXAM_RESULT);
            subscribedNotiificationsList.add(TAG_NOTIFICATION_EXAM_TIMETABLE);


        }
        if (prefs.getBoolean(KEY_DISTANCE_EDUCATION_NEEDED, false)) {
            if (!"none".equals(selectedCourse))
                subscribedNotiificationsList.add(TAG_COMMON_DISTANCE + selectedCourse);
            if (!"none".equals(selectedDepartment))
                subscribedNotiificationsList.add(TAG_COMMON_DISTANCE + selectedDepartment);

            subscribedNotiificationsList.add(TAG_NOTIFICATION_DISTANCE_CONTACT_CLASS);
            subscribedNotiificationsList.add(TAG_NOTIFICATION_DISTANCE_NOTIFICATIONS);
            subscribedNotiificationsList.add(TAG_NOTIFICATION_DISTANCE_QUESTION_BANK);
            subscribedNotiificationsList.add(TAG_NOTIFICATION_DISTANCE_STUDY_MATERIAL);
        }
        if (prefs.getBoolean(KEY_VC_DESK_NEEDED, false)) {
            subscribedNotiificationsList.add(TAG_NOTIFICATION_VC_DESK);
        }
        if (prefs.getBoolean(KEY_UOC_NEWS_NEEDED, false)) {
            subscribedNotiificationsList.add(TAG_NOTIFICATION_NEWS);
        }
        if (prefs.getBoolean(KEY_UOC_ORDERS_NEEDED, false)) {
            subscribedNotiificationsList.add(TAG_NOTIFICATION_ORDERS);
        }
        return subscribedNotiificationsList.toArray(new String[subscribedNotiificationsList.size()]);
    }

}
