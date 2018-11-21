
package zo.den.myapplication.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import zo.den.myapplication.pojo.CreationDate;
import zo.den.myapplication.pojo.LastModificationDate;
import zo.den.myapplication.pojo.Title;

public class Payload {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("title")
    @Expose
    private Title title;
    @SerializedName("creationDate")
    @Expose
    private CreationDate creationDate;
    @SerializedName("lastModificationDate")
    @Expose
    private LastModificationDate lastModificationDate;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("bankInfoTypeId")
    @Expose
    private Integer bankInfoTypeId;
    @SerializedName("typeId")
    @Expose
    private String typeId;

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public CreationDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(CreationDate creationDate) {
        this.creationDate = creationDate;
    }

    public LastModificationDate getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(LastModificationDate lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getBankInfoTypeId() {
        return bankInfoTypeId;
    }

    public void setBankInfoTypeId(Integer bankInfoTypeId) {
        this.bankInfoTypeId = bankInfoTypeId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getText() {
        return text;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
