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
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.microsoft.windowsazure.notifications.NotificationsHandler;

public class PushNotificationHandler extends NotificationsHandler implements GravitySupport {


    public static final int NOTIFICATION_ID = 1;
    private NotificationManager mNotificationManager;
    NotificationCompat.Builder builder;
    Context ctx, currentContext;


    SharedPreferences prefs;

    @Override
    public void onRegistered(Context context, final String gcmRegistrationId) {
        super.onRegistered(context, gcmRegistrationId);
        currentContext = context;

        new AsyncTask<Void, Void, Void>() {

            protected Void doInBackground(Void... params) {
                try {
                    prefs = currentContext.getSharedPreferences(KEY_PREFERENCE_ID, Context.MODE_APPEND);
                    String selectedCourse = prefs.getString(KEY_SELECTED_COURSE_ID, "none");

                    String[] tags = {TAG_NOTIFICATION_COMMON, selectedCourse};
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

        sendNotification(nhMessage, msgContent);
    }

    private void sendNotification(String msg, String content) {
        mNotificationManager = (NotificationManager)
                ctx.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(ctx, 0,
                new Intent(ctx, NotificationActivity.class), 0);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(ctx)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("University")
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText(msg))
                        .setContentText(content);

        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }

}
