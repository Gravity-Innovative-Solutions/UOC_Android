package in.gravitykerala.universityofcalicut;

/**
 * Created by Prakash on 20/06/2015.
 */
public class newMobileNotification {

    /**
     * Item Id
     */
    @com.google.gson.annotations.SerializedName("id")
    private String mId;

    @com.google.gson.annotations.SerializedName("title")
    public String mTitle;

    @com.google.gson.annotations.SerializedName("content")
    public String mcontent;

    @com.google.gson.annotations.SerializedName("courseName")
    public String mMessageType;

    @com.google.gson.annotations.SerializedName("courseId")
    public String mPushNeeded;

    //Hours

    public newMobileNotification(String title, String content, String messageType, String pushNeeded) {
        this.mTitle = title;
        this.mcontent = content;
        this.mMessageType = messageType;
        this.mPushNeeded = pushNeeded;
        //this.mPushTimeToLive = pushTimeToLive;
    }
}
