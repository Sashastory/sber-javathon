package de.jonashackt.springbootvuejs.yandex;

import com.google.gson.Gson;
import de.jonashackt.springbootvuejs.service.impl.YandexMapsCoordinatesResolver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import reactor.core.publisher.Mono;

@RunWith(SpringJUnit4ClassRunner.class)
public class YandexMapsSearchTest {

    @Autowired
    private YandexMapsCoordinatesResolver yandexMapsCoordinatesResolver;

    @Before
    public void init() {
    }

    @Test
    public void search() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("text", "банкоматы Сбербанк");
        Mono<Gson> res = yandexMapsCoordinatesResolver.search(params);
        System.out.println(res.block());
    }
}