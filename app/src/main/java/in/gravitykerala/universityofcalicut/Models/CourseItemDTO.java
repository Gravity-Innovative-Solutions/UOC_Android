package in.gravitykerala.universityofcalicut.Models;

/**
 * Created by Prakash on 18/07/2015.
 */
public class CourseItemDTO {
    /**
     * Item Id
     */
    @com.google.gson.annotations.SerializedName("id")
    public String courseId;

    @com.google.gson.annotations.SerializedName("courseName")
    public String courseName;

    @com.google.gson.annotations.SerializedName("departmentName")
    public String departmentName;

    @com.google.gson.annotations.SerializedName("courseInfo")
    public String courseInfo;

    @com.google.gson.annotations.SerializedName("departmentId")
    private String departmentId;


}
