package ru.javathon.springbootvuejs.service.impl;

import de.jonashackt.springbootvuejs.model.gsonobject.*;
import lombok.ToString;
import org.springframework.stereotype.Service;
import ru.javathon.springbootvuejs.model.gsonobject.*;

import java.util.ArrayList;
import java.util.List;

@Service
@ToString
public class CashMachineTestService {
    public GsonObject getTestGson() {
        GsonObject atms = new GsonObject();
        atms.setType("AtmCollection");
        atms.setMetadata(new Metadata("Банкоматы","Javathon2019"));
        List<Feature> featureList = new ArrayList<>();

        Feature feature = new Feature();
        feature.setId(0);
        feature.setType("Feature");

        Properties properties = new Properties();
        properties.setDescription("Description");
        properties.setFill("#ed4543");
        properties.setFillOpacity(0.6);
        properties.setStroke("#ed4543");
        properties.setStrokeOpacity(0.9);
        properties.setStrokeWidth("5");
        feature.setProperties(properties);

        Geometry geometry = new Geometry();
        geometry.setType("Point");

        List<List<List<Double>>> features = new ArrayList<>();
        List<List<Double>> coordinates = new ArrayList<>();
        List<Double> coordinate = new ArrayList<>();

        coordinate.add(37.49551079785137);
        coordinate.add(55.78907714681517);

        coordinates.add(coordinate);
        features.add(coordinates);

        geometry.setCoordinates(features);
        feature.setGeometry(geometry);
        featureList.add(feature);
        atms.setFeatures(featureList);

        return atms;
    }
}
