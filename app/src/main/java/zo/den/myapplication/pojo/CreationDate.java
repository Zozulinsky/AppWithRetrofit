
package zo.den.myapplication.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreationDate {

    @SerializedName("milliseconds")
    @Expose
    private Integer milliseconds;

    public Integer getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(Integer milliseconds) {
        this.milliseconds = milliseconds;
    }

}
