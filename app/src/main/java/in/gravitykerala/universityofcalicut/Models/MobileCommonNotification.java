package in.gravitykerala.universityofcalicut.Models;

/**
 * Created by USER on 7/26/2015.
 */
public class MobileCommonNotification {
    @com.google.gson.annotations.SerializedName("id")
    private String mId;

    @com.google.gson.annotations.SerializedName("distanceEducationNotification")
    public MobileNotification[] DEN;
    @com.google.gson.annotations.SerializedName("news")
    public MobileNotification[] News;
    @com.google.gson.annotations.SerializedName("universityOrders")
    public MobileNotification[] UO;
    @com.google.gson.annotations.SerializedName("contactClass")
    public MobileNotification[] CC;
    @com.google.gson.annotations.SerializedName("pareekshabhavanNotification")
    public MobileNotification[] PBN;
    @com.google.gson.annotations.SerializedName("result")
    public MobileNotification[] RESLT;
    @com.google.gson.annotations.SerializedName("studyMaterials")
    public MobileNotification[] SM;
    @com.google.gson.annotations.SerializedName("questionBank")
    public MobileNotification[] QB;
    @com.google.gson.annotations.SerializedName("timeTable")
    public MobileNotification[] TT;

}
