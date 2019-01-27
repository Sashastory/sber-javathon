package ru.javathon.springbootvuejs.service.impl;

import ru.javathon.springbootvuejs.model.gsonobject.Feature;
import ru.javathon.springbootvuejs.model.gsonobject.GsonObject;
import ru.javathon.springbootvuejs.service.ICoordinatesResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class YandexMapsCoordinatesResolver implements ICoordinatesResolver {

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

    @Override
    public Mono<String> search(GsonObject request, String type) {

        List<Feature> features = request.getFeatures();
        Feature feature = features.get(0);
        List<List<Double>> coordinates = feature.getGeometry().getCoordinates().get(0);

        String bboxParam = bboxify(coordinates);

        return webClient.get()
                .uri(builder -> builder
                        .queryParam("apikey", KEY)
                        .queryParam("text", type)
                        .queryParam("type", "biz")
                        // TODO: l10n
                        .queryParam("lang", "ru_RU")
                        .queryParam("bbox", bboxParam)
                        .build())
                .exchange()
                .flatMap(resp -> resp.bodyToMono(String.class));
    }

    private String bboxify(List<List<Double>> coordinates) {

        Double minLat = 90.0;
        Double minLng = 180.0;
        Double maxLat = -90.0;
        Double maxLng = -180.0;

        for (List<Double> coordinate : coordinates) {
            Double currLng = coordinate.get(0);
            Double currLat = coordinate.get(1);

            if (currLat < minLat) minLat = currLat;
            if (currLat > maxLat) maxLat = currLat;
            if (currLng < minLng) minLng = currLng;
            if (currLng > maxLng) maxLng = currLng;
        }

        return minLng + "," +
                minLat + "~" +
                maxLng + "," +
                maxLat;
    }
}
