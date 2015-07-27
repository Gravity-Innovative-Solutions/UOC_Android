package in.gravitykerala.universityofcalicut;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import java.util.AbstractList;
import java.util.List;

import in.gravitykerala.universityofcalicut.Models.MobileCommonNotification;
import in.gravitykerala.universityofcalicut.Models.MobileNotification;

//import in.gravitykerala.easysyllabi.R;

public class NewCommonNotificationActivity extends Activity {
    private MobileServiceClient mClient;
    private TextView tv;
    private MobileServiceTable<MobileCommonNotification> mToDoTable;


    private MCNAdapter mAdapter;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_notification);
        // mProgressBar = (ProgressBar) findViewById(R.id.loadingProgressBar);

        //buttonRefresh = (Button) findViewById(R.id.button_refresh);
        // Initialize the progress bar
        // mProgressBar.setVisibility(ProgressBar.GONE);

//            buttonRefresh.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    refreshItemsFromTable();
//
//                }
        // });
        mClient = NotificationActivity.mClient;

        // Get the Mobile Service Table instance to use

        mToDoTable = mClient.getTable(MobileCommonNotification.class);

        // mTextNewToDo = (EditText) findViewById(R.id.textNewToDo);

        // Create an adapter to bind the items with the view
        mAdapter = new MCNAdapter(this, R.layout.single_row_list_notification);
        ListView listViewToDo = (ListView) findViewById(R.id.listViewToDo);
        listViewToDo.setAdapter(mAdapter);
//        Intent newActivity0=getIntent();
//        String ExamId  = newActivity0.getStringExtra("StudentMarkDTO?ExamId=" + "id");
//        String s = getIntent().getExtras().getString("id");
//        Toast.makeText(getBaseContext(), s,
//                Toast.LENGTH_LONG).show();
        // Load the items from the Mobile Service
        // refreshItemsFromTable();


        List<Pair<String, String>> parameters = new AbstractList<Pair<String, String>>() {
            @Override
            public Pair<String, String> get(int i) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };


        final ListenableFuture<MobileCommonNotification> result = mClient.invokeApi("CommonNotification", MobileCommonNotification.class);

        Futures.addCallback(result, new FutureCallback<MobileCommonNotification>() {
            @Override
            public void onFailure(Throwable exc) {
                exc.printStackTrace();
                Log.d("Output", "error");
                // createAndShowDialog((Exception) exc, "Error");
            }

            @Override
            public void onSuccess(MobileCommonNotification result) {
                String[] r = null;
                String r1 = "";
                for (int i = 0; i < result.CC.length; i++) {
                    Log.d("ID", result.CC[i].mTitle);

                    r1 = r1 + result.CC[i].mTitle + "\t" + result.CC[i].mcontent + "\t" + result.CC[i].url + "\n";
                }

                for (MobileNotification item : result.DEN) {

                    mAdapter.add(item);
                }
                for (MobileNotification item : result.News) {

                    mAdapter.add(item);
                }
                for (MobileNotification item : result.UO) {

                    mAdapter.add(item);
                }
                for (MobileNotification item : result.CC) {

                    mAdapter.add(item);
                }
                for (MobileNotification item : result.PBN) {

                    mAdapter.add(item);
                }
                for (MobileNotification item : result.RESLT) {

                    mAdapter.add(item);
                }
                for (MobileNotification item : result.SM) {

                    mAdapter.add(item);
                }
                for (MobileNotification item : result.QB) {

                    mAdapter.add(item);
                }
                for (MobileNotification item : result.TT) {

                    mAdapter.add(item);
                }
//                tv.setText(r1);

            }
        });

    }
//    public void Internal(final MobileCommonNotification.Exam item){
//
//        Intent newActivity0 = new Intent(this, InternlSubjectMark.class).putExtra("<id>", item.getId());
//        newActivity0.putExtra("id",item.getId());
//        startActivity(newActivity0);


    //}
}