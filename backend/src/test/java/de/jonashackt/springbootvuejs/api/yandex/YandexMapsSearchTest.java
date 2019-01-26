package de.jonashackt.springbootvuejs.api.yandex;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class YandexMapsSearchTest {

    @Autowired
    private YandexMapsSearch yandexMapsSearch;

    @Before
    public void init() {
    }

    @Test
    public void search() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("text", "банкоматы Сбербанк");
        Mono<Gson> res = yandexMapsSearch.search(params);
        System.out.println(res.block());
    }
}