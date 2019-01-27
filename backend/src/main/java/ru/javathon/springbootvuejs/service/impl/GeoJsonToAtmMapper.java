package ru.javathon.springbootvuejs.service.impl;

import com.mongodb.BasicDBObject;
import ru.javathon.springbootvuejs.model.gsonobject.yandex.Feature;
import ru.javathon.springbootvuejs.model.gsonobject.yandex.GeoJsonObject;
import ru.javathon.springbootvuejs.service.IMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class GeoJsonToAtmMapper implements IMapper<Feature> {

    private Logger logger = LoggerFactory.getLogger(GeoJsonToAtmMapper.class);

    private MongoTemplate mongoTemplate;

    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostConstruct
    public void init() {
    }

    @Override
    public List<Feature> map(String geoJson) {

        GeoJsonObject read = mongoTemplate
                .getConverter()
                .read(GeoJsonObject.class, BasicDBObject.parse(geoJson));

        List<Feature> atms = read.getFeatures();
        for (Feature atm : atms) {
            mongoTemplate.insert(atm, "actualAtm");
        }
        return atms;
    }
}
