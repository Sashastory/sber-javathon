package de.jonashackt.springbootvuejs.yandex;

import com.github.filosganga.geogson.gson.GeometryAdapterFactory;
import com.github.filosganga.geogson.jts.JtsAdapterFactory;
import com.github.filosganga.geogson.model.FeatureCollection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import de.jonashackt.springbootvuejs.model.gsonobject.Feature;
import de.jonashackt.springbootvuejs.model.gsonobject.Geometry;
import de.jonashackt.springbootvuejs.model.gsonobject.GsonObject;
import de.jonashackt.springbootvuejs.service.impl.YandexMapsCoordinatesResolver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = { YandexMapsCoordinatesResolver.class })
@EnableConfigurationProperties
@RunWith(SpringJUnit4ClassRunner.class)
public class YandexMapsCoordinatesResolverTest {

    @Autowired
    private YandexMapsCoordinatesResolver yandexMapsCoordinatesResolver;

    @Before
    public void init() {
    }

    @Test
    public void search() {

        GsonObject object = new GsonObject();
        Feature f = new Feature();
        Geometry g = new Geometry();
        g.setCoordinates(
                new ArrayList<List<List<Double>>>() {{
                    add(new ArrayList<List<Double>>() {{
                        add(new ArrayList<Double>() {{
                            add(37.5264133);
                            add(55.7335432);
                        }});
                        add(new ArrayList<Double>() {{
                            add(37.578392);
                            add(55.705260);
                        }});
                    }});
                }});
        f.setGeometry(g);
        object.setFeatures(Arrays.asList(f));


        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new JtsAdapterFactory())
                .registerTypeAdapterFactory(new GeometryAdapterFactory())
                .create();

        Mono<String> mono = yandexMapsCoordinatesResolver.search("blahblah", "Банкоматы Сбербанк");
        String res = mono.block();

        FeatureCollection featureCollection = gson.fromJson(res, FeatureCollection.class);
        System.out.println(res);

    }

    @Test
    public void findCityCoordinates() {
        yandexMapsCoordinatesResolver.findCityCoordinates("Москва");
    }
}