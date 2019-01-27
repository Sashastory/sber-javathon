package ru.javathon.springbootvuejs.model.gsonobject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.ToString;

@ToString
public class Properties {

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("fill")
    @Expose
    private String fill;
    @SerializedName("fill-opacity")
    @Expose
    private Double fillOpacity;
    @SerializedName("stroke")
    @Expose
    private String stroke;
    @SerializedName("stroke-width")
    @Expose
    private String strokeWidth;
    @SerializedName("stroke-opacity")
    @Expose
    private Double strokeOpacity;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    public Double getFillOpacity() {
        return fillOpacity;
    }

    public void setFillOpacity(Double fillOpacity) {
        this.fillOpacity = fillOpacity;
    }

    public String getStroke() {
        return stroke;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    public String getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(String strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public Double getStrokeOpacity() {
        return strokeOpacity;
    }

    public void setStrokeOpacity(Double strokeOpacity) {
        this.strokeOpacity = strokeOpacity;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "description='" + description + '\'' +
                ", fill='" + fill + '\'' +
                ", fillOpacity=" + fillOpacity +
                ", stroke='" + stroke + '\'' +
                ", strokeWidth='" + strokeWidth + '\'' +
                ", strokeOpacity=" + strokeOpacity +
                '}';
    }
}
