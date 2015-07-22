package in.gravitykerala.universityofcalicut.Models;

/**
 * Created by Prakash on 20/06/2015.
 */
public class MobileNotification {

    /**
     * Item Id
     */
    @com.google.gson.annotations.SerializedName("id")
    private String mId;

    @com.google.gson.annotations.SerializedName("title")
    public String mTitle;
    @com.google.gson.annotations.SerializedName("url")
    public String url;
    @com.google.gson.annotations.SerializedName("isContentURL")
    public String cntnturl;
    @com.google.gson.annotations.SerializedName("depaartmentId")
    public String DprtId;
    @com.google.gson.annotations.SerializedName("depaartmentName")
    public String DprtName;

    @com.google.gson.annotations.SerializedName("content")
    public String mcontent;

    @com.google.gson.annotations.SerializedName("courseName")
    public String mMessageType;

    @com.google.gson.annotations.SerializedName("courseId")
    public String mPushNeeded;

   //Hours

    public MobileNotification(String title, String content, String messageType, String pushNeeded)
    {
        this.mTitle = title;
        this.mcontent = content;
        this.mMessageType = messageType;
        this.mPushNeeded = pushNeeded;
        //this.mPushTimeToLive = pushTimeToLive;
    }
}
