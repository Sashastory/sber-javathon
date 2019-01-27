package de.jonashackt.springbootvuejs.service.impl;

import de.jonashackt.springbootvuejs.model.CashMachine;
import de.jonashackt.springbootvuejs.repository.GeoJsonObjectRepository;
import de.jonashackt.springbootvuejs.service.IMapper;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class GeoJsonToCashMachineMapper implements IMapper<CashMachine> {

    private Logger logger = LoggerFactory.getLogger(GeoJsonToCashMachineMapper.class);

    private GeoJsonObjectRepository repository;

    @Autowired
    public void setRepository(GeoJsonObjectRepository repository) {
        this.repository = repository;
    }

    private MongoTemplate mongoTemplate;

    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostConstruct
    public void init() {
    }

    @Override
    public List<CashMachine> map(String geoJson) {

        Document doc = Document.parse(geoJson);

        mongoTemplate.insert(doc, "atm");
//        repository.save()
        return null;
    }
}
