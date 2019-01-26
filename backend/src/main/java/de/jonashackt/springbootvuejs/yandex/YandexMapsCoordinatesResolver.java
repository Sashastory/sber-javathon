package de.jonashackt.springbootvuejs.yandex;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Service
public class YandexMapsCoordinatesResolver {

    @Value("${key.yandex}")
    private String KEY;
    private WebClient webClient;

    @PostConstruct
    public void init() {
        webClient = WebClient
                .builder()
                .baseUrl("https://search-maps.yandex.ru/v1/")
                .build();
    }

    public Mono<Gson> search(MultiValueMap<String, String> params) {
        Mono<Gson> mono = webClient.get()
                .uri(builder -> builder
                        .queryParam("apikey", KEY)
                        .queryParams(params)
                        .path("tracks")
                        .build())
                .exchange()
                .flatMap(resp -> resp.bodyToMono(Gson.class));

        return mono;
    }
}
