package de.jonashackt.springbootvuejs.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import de.jonashackt.springbootvuejs.model.Assessment;
import de.jonashackt.springbootvuejs.model.AssessmentParams;
import de.jonashackt.springbootvuejs.model.gsonobject.GsonObject;
import de.jonashackt.springbootvuejs.model.gsonobject.yandex.Feature;
import de.jonashackt.springbootvuejs.model.gsonobject.yandex.GeoJsonObject;
import de.jonashackt.springbootvuejs.service.ICashMachineAssesser;
import de.jonashackt.springbootvuejs.service.ICoordinatesResolver;
import de.jonashackt.springbootvuejs.service.IMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aleksandr
 * @date 2019-01-26 20:58
 */
@Service
public class ExpertSystemService {

    private ICashMachineAssesser assesser;

    private ICoordinatesResolver coordinatesResolver;

    private IMapper<Feature> mapper;

    private Gson GSON = new Gson();

    public ExpertSystemService(ICashMachineAssesser assesser, ICoordinatesResolver coordinatesResolver,
                               IMapper<Feature> mapper) {
        this.assesser = assesser;
        this.coordinatesResolver = coordinatesResolver;
        this.mapper = mapper;
    }

    public GeoJsonObject getCashMachines(GsonObject currentLocation) {

        // ПОЛУЧАЕМ GEOJSON С БАНКОМАТАМИ
        Mono<String> geoJson = coordinatesResolver.search(currentLocation, "банкоматы Сбербанка");
        String jsonValue = geoJson.block();

        GeoJsonObject geoJsonObject = GSON.fromJson(jsonValue, new TypeToken<GeoJsonObject>() {}.getType());


        List<Feature> suitableCashMachines = new ArrayList<>();
        if (geoJsonObject != null) {
            List<Feature> cashMachines = mapper.map(jsonValue);
            for (Feature cashMachine : cashMachines) {
                List<Double> coordinates = cashMachine.getGeometry().getCoordinates();
                Assessment result = assesser.getAssessment(coordinates, new AssessmentParams());

                if (Assessment.SUITABLE.equals(result)) {
                    suitableCashMachines.add(cashMachine);
                }
            }
        }

        GeoJsonObject resultCashMachines = new GeoJsonObject();
        resultCashMachines.setType("FeatureCollection");
        resultCashMachines.setFeatures(suitableCashMachines);

        // ОЦЕНИВАЕМ ЯКОБЫ СБЕРОМ ДОСТУПНЫ ЛИ БАНКОМАТЫ
        // ОНИ КЛАДУТ ТОГГЛ В ПОЛЕ ДЕСКРИПШН

        // МАПИМ ЕГО В БАНКОМАТЫ И СОХРАНЯЕМ ИХ В БД



        // ПОКА ПРОСТО ОТДАЕМ ЕГО В ИСХОДНОМ ВИДЕ
        return resultCashMachines;

    }

}
