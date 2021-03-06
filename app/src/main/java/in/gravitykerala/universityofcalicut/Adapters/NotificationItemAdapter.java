package in.gravitykerala.universityofcalicut.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import in.gravitykerala.universityofcalicut.Models.newMobileNotification;
import in.gravitykerala.universityofcalicut.R;

/**
 * Adapter to bind a ToDoItem List to a view
 */
public class NotificationItemAdapter extends ArrayAdapter<newMobileNotification> {

    /**
     * Adapter context
     */
    Context mContext;

    /**
     * Adapter View layout
     */
    int mLayoutResourceId;

    public NotificationItemAdapter(Context context, int layoutResourceId) {
        super(context, layoutResourceId);

        mContext = context;
        mLayoutResourceId = layoutResourceId;
    }

    /**
     * Returns the view for a specific item on the list
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        final newMobileNotification currentItem = getItem(position);

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

        row.setTag(currentItem);
        final TextView tvTitle = (TextView) row.findViewById(R.id.row_title);
        final TextView tvContent = (TextView) row.findViewById(R.id.row_content);
        tvTitle.setText(currentItem.title);
        tvContent.setText(currentItem.content);


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