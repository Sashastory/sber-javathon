package de.jonashackt.springbootvuejs.service.impl;

import de.jonashackt.springbootvuejs.model.gsonobject.Feature;
import de.jonashackt.springbootvuejs.model.gsonobject.GsonObject;
import de.jonashackt.springbootvuejs.service.ICoordinatesResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleUnaryOperator;

@Service
public class YandexMapsCoordinatesResolver implements ICoordinatesResolver {

    @Value("${key.yandex.places}")
    private String KEY_PLACES;
    @Value("${key.yandex.geocoder}")
    private String KEY_GEOCODER;

    private WebClient searchWebClient;
    private GsonJsonParser jsonParser;

    @PostConstruct
    public void init() {

        searchWebClient = WebClient
                .builder()
                .baseUrl("https://search-maps.yandex.ru/v1/")
                .build();
    }

    // SORRY!!!
    public List<List<Double>> findCityCoordinates(String cityName) {
        return new ArrayList<List<Double>>(){{
            add(new ArrayList<Double>(){{
                add(36.803259);
                add(55.142627);
            }});
            add(new ArrayList<Double>(){{
                add(37.967682);
                add(56.021281);
            }});
        }};
    }

    @Override
    public Mono<String> search(String location, String type) {
        List<List<Double>> coordinates = findCityCoordinates(location);

        return searchWebClient.get()
                .uri(builder -> builder
                        .queryParam("apikey", KEY_PLACES)
                        .queryParam("text", type)
                        .queryParam("type", "biz")
                        .queryParam("lang", "ru_RU")
                        .queryParam("bbox", coordinates)
                        // FIXME offset!!!!
                        .queryParam("results", "500")
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
