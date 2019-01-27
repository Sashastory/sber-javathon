
package de.jonashackt.springbootvuejs.model.gsonobject.yandex;

import java.util.List;

public class GeoJsonObject {

    private String type;
    private List<Feature> features = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "GeoJsonObject{" +
                "type='" + type + '\'' +
                ", features=" + features +
                '}';
    }
}
