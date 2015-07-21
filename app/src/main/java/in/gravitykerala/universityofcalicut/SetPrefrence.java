package in.gravitykerala.universityofcalicut;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class SetPrefrence extends AppCompatActivity {
    MyCustomAdapter dataAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_prefrence);
        //Generate list View from ArrayList
        displayListView();

        checkButtonClick();
    }

    private void displayListView() {

        //Array list of countries
        ArrayList<YourPreference> prefList = new ArrayList<YourPreference>();
        YourPreference pref = new YourPreference("AFG", "Afghanistan", false);
        prefList.add(pref);
        pref = new YourPreference("ALB", "Albania", true);
        prefList.add(pref);
        pref = new YourPreference("DZA", "Algeria", false);
        prefList.add(pref);
        pref = new YourPreference("ASM", "American Samoa", true);
        prefList.add(pref);
        pref = new YourPreference("AND", "Andorra", true);
        prefList.add(pref);
        pref = new YourPreference("AGO", "Angola", false);
        prefList.add(pref);
        pref = new YourPreference("AIA", "Anguilla", false);
        prefList.add(pref);

        //create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(this,
                R.layout.pref_info, prefList);
        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                YourPreference pref = (YourPreference) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "Clicked on Row: " + pref.getName(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    private class MyCustomAdapter extends ArrayAdapter<YourPreference> {

        private ArrayList<YourPreference> prefList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<YourPreference> prefList) {
            super(context, textViewResourceId, prefList);
            this.prefList = new ArrayList<YourPreference>();
            this.prefList.addAll(prefList);
        }

        private class ViewHolder {
            TextView code;
            CheckBox name;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.pref_info, null);

                holder = new ViewHolder();
                holder.code = (TextView) convertView.findViewById(R.id.code);
                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);

                holder.name.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v;
                        YourPreference pref = (YourPreference) cb.getTag();
                        Toast.makeText(getApplicationContext(),
                                "Clicked on Checkbox: " + cb.getText() +
                                        " is " + cb.isChecked(),
                                Toast.LENGTH_LONG).show();
                        pref.setSelected(cb.isChecked());
                    }
                });
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            YourPreference pref = prefList.get(position);
            holder.code.setText(" (" + pref.getCode() + ")");
            holder.name.setText(pref.getName());
            holder.name.setChecked(pref.isSelected());
            holder.name.setTag(pref);

            return convertView;

        }

    }

    private void checkButtonClick() {


        Button myButton = (Button) findViewById(R.id.findSelected);
        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer responseText = new StringBuffer();
                responseText.append("The following were selected...\n");

                ArrayList<YourPreference> prefList = dataAdapter.prefList;
                for (int i = 0; i < prefList.size(); i++) {
                    YourPreference pref = prefList.get(i);
                    if (pref.isSelected()) {
                        responseText.append("\n" + pref.getName());
                    }
                }

                Toast.makeText(getApplicationContext(),
                        responseText, Toast.LENGTH_LONG).show();

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_set_prefrence, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
