
package ru.javathon.springbootvuejs.model.gsonobject.yandex;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("atm")
public class Feature {

    private String type;
    private Properties properties;
    private Geometry geometry;
    private List<Geometry> geometries = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public List<Geometry> getGeometries() {
        return geometries;
    }

    public void setGeometries(List<Geometry> geometries) {
        this.geometries = geometries;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "type='" + type + '\'' +
                ", properties=" + properties +
                ", geometry=" + geometry +
                ", geometries=" + geometries +
                '}';
    }
}
