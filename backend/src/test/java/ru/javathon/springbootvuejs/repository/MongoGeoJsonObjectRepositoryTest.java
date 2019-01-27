package ru.javathon.springbootvuejs.repository;

import ru.javathon.springbootvuejs.model.gsonobject.yandex.GeoJsonObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MongoGeoJsonObjectRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(MongoGeoJsonObjectRepositoryTest.class);
    @Autowired
    private GeoJsonObjectRepository repository;

    @Test
    public void test() {
        List<GeoJsonObject> all = repository.findAll();

        for (GeoJsonObject geoJsonObject : all) {
            logger.info(String.valueOf(geoJsonObject));
        }
    }
}