package de.jonashackt.springbootvuejs.model.gsonobject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MetaData {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("creator")
    @Expose
    private String creator;

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
}
