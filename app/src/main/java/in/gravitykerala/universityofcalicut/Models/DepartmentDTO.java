package in.gravitykerala.universityofcalicut.Models;

/**
 * Created by Prakash on 22/07/2015.
 * expect112@gmail.com
 */
public class DepartmentDTO {

    /**
     * departmentName : sample string 1
     * id : sample string 3
     * info : sample string 2
     */
    @com.google.gson.annotations.SerializedName("departmentName")
    private String departmentName;
    @com.google.gson.annotations.SerializedName("id")
    private String id;
    @com.google.gson.annotations.SerializedName("info")
    private String info;

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }
}
