package in.gravitykerala.universityofcalicut;

/**
 * Created by Jasmi on 21-07-2015.
 */
public class YourPreference {
    String code = null;
    String name = null;
    boolean selected = false;

    public YourPreference(String code, String name, boolean selected) {
        super();
        this.code = code;
        this.name = name;
        this.selected = selected;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
