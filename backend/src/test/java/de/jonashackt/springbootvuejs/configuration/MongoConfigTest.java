package de.jonashackt.springbootvuejs.configuration;

import de.jonashackt.springbootvuejs.service.impl.YandexMapsCoordinatesResolver;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
@EnableConfigurationProperties
public class MongoConfigTest {

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void smoke() {

    }
}