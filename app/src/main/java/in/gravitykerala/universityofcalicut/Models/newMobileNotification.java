package in.gravitykerala.universityofcalicut.Models;

/**
 * Created by Prakash on 20/06/2015.
 */
public class newMobileNotification {

    /**
     * Item Id
     */
    @com.google.gson.annotations.SerializedName("id")
    private String id;

    @com.google.gson.annotations.SerializedName("title")
    public String title;

    @com.google.gson.annotations.SerializedName("content")
    public String content;

    @com.google.gson.annotations.SerializedName("courseName")
    public String courseName;

    @com.google.gson.annotations.SerializedName("courseId")
    public String courseId;

    //Hours

    public newMobileNotification(String title, String content, String courseName, String courseId) {
        this.title = title;
        this.content = content;
        this.courseName = courseName;
        this.courseId = courseId;
        //this.mPushTimeToLive = pushTimeToLive;
    }
}
