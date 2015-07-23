package in.gravitykerala.universityofcalicut.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

import in.gravitykerala.universityofcalicut.Models.CourseItemDTO;
import in.gravitykerala.universityofcalicut.Models.DepartmentDTO;


/**
 * Created by Prakash on 22/07/2015.
 * expect112@gmail.com
 */
public class CourseSpinAdapter extends ArrayAdapter<CourseItemDTO> {

    // Your sent context
    private Context context;
    // Your custom values for the spinner (User)
    private List<CourseItemDTO> values;

    int dropDownResourceId;
    int layouResourceId;

    public CourseSpinAdapter(Context context, int layouResourceId, int dropDownResourceId,
                             List<CourseItemDTO> values) {

        super(context, layouResourceId, values);

        this.context = context;
        this.values = values;
        this.layouResourceId = layouResourceId;
        this.dropDownResourceId = dropDownResourceId;


    }

    public int getCount() {
        return values.size();
    }

    public CourseItemDTO getItem(int position) {
        return values.get(position);
    }

    public long getItemId(int position) {
        return position;
    }


    // And the "magic" goes here
    // This is for the "passive" state of the spinner
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView spinnerRow = (TextView) convertView;
        final CourseItemDTO department = getItem(position);
        if (spinnerRow == null) {
            LayoutInflater inflator = ((Activity) context).getLayoutInflater();
            spinnerRow = (TextView) inflator.inflate(layouResourceId, parent, false); //Normal view here
        }
        spinnerRow.setText(department.courseName);
        spinnerRow.setTag(department.courseId);
        return spinnerRow;

    }

    // And here is when the "chooser" is popped up
    // Normally is the same view, but you can customize it if you want
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView spinnerRow = (TextView) convertView;
        final CourseItemDTO department = getItem(position);
        if (spinnerRow == null) {
            LayoutInflater inflator = ((Activity) context).getLayoutInflater();
            spinnerRow = (TextView) inflator.inflate(dropDownResourceId, parent, false); // Dropdown view here
        }
        spinnerRow.setText(department.courseName);
        spinnerRow.setTag(department.courseId);
        return spinnerRow;
    }
}
