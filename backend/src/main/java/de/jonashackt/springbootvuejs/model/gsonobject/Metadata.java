package de.jonashackt.springbootvuejs.model.gsonobject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.ToString;

@ToString
public class Metadata {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("creator")
    @Expose
    private String creator;
    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("amount")
    @Expose
    private Integer amount;

    public Metadata() {
    }

    public Metadata(String name, String creator) {
        this.name = name;
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "name='" + name + '\'' +
                ", creator='" + creator + '\'' +
                '}';
    }
}
