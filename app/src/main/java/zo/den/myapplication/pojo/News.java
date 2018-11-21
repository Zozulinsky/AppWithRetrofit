
package zo.den.myapplication.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class News {

    @SerializedName("resultCode")
    @Expose
    private String resultCode;
    @SerializedName("payloadList")
    @Expose
    private Payload payload;

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    @SerializedName("payload")
    @Expose
    private List<Payload> payloadList;
    @SerializedName("trackingId")
    @Expose
    private String trackingId;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public List<Payload> getPayloadList() {

        return payloadList;
    }

    public void setPayloadList(List<Payload> payloadList) {
        this.payloadList = payloadList;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

}
