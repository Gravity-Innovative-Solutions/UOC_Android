package in.gravitykerala.universityofcalicut;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import in.gravitykerala.universityofcalicut.Models.MobileNotification;


public class MCNAdapter extends ArrayAdapter<MobileNotification> {


    /**
     * Adapter to bind a ToDoItem List to a view
     */


    /**
     * Adapter context
     */
    Context mContext;


    /**
     * Adapter View layout
     */
    int mLayoutResourceId;

    public MCNAdapter(Context context, int layoutResourceId) {
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

        final MobileNotification currentItem = getItem(position);

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

        row.setTag(currentItem);

        final TextView tvTitle = (TextView) row.findViewById(R.id.row_title);
        final TextView tvContent = (TextView) row.findViewById(R.id.row_content);
        final TextView tvurl = (TextView) row.findViewById(R.id.row_url);
        tvTitle.setText(currentItem.mTitle);
        tvContent.setText(currentItem.mcontent);
        tvurl.setVisibility(TextView.GONE);
        if (currentItem.url != null && !(currentItem.url.isEmpty())) {
            tvurl.setText(currentItem.url);

            row.setOnClickListener(new View.OnClickListener() {
                //
                @Override
                public void onClick(View arg0) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(currentItem.url));
                    mContext.startActivity(intent);


                }
            });
        }
        return row;

    }


}

