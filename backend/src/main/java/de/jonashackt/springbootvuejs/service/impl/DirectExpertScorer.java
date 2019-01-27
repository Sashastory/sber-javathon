package de.jonashackt.springbootvuejs.service.impl;

import de.jonashackt.springbootvuejs.model.Action;
import de.jonashackt.springbootvuejs.model.Assessment;
import de.jonashackt.springbootvuejs.model.AssessmentParams;
import de.jonashackt.springbootvuejs.model.gsonobject.GsonObject;
import de.jonashackt.springbootvuejs.model.gsonobject.yandex.Feature;
import de.jonashackt.springbootvuejs.model.gsonobject.yandex.GeoJsonObject;
import de.jonashackt.springbootvuejs.service.AbstractServiceScorer;
import de.jonashackt.springbootvuejs.service.ICashMachineAssesser;
import de.jonashackt.springbootvuejs.service.ICoordinatesResolver;
import de.jonashackt.springbootvuejs.service.IMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * Сервис для оценки банкоматов напрямую из полученных данных от Yandex API
 * @author aleksandr
 * @date 2019-01-26 20:58
 */
@Service
public class DirectExpertScorer extends AbstractServiceScorer {


    public DirectExpertScorer(ICashMachineAssesser assesser, ICoordinatesResolver coordinatesResolver,
                              IMapper<Feature> mapper) {

        super(assesser, coordinatesResolver, mapper);
    }

    @Override
    public GeoJsonObject getCashMachines(GsonObject currentLocation) {
        // ТУТ ЖЕ НАДО ИСКАТЬ В БД!

        // ПОЛУЧАЕМ GEOJSON С БАНКОМАТАМИ
        Mono<String> geoJson = coordinatesResolver.search(currentLocation, "банкоматы Сбербанка");

        List<Action> actions = new ArrayList<>();
        actions.add(Action.valueOf(currentLocation.getMetadata().getAction().toUpperCase()));
        AssessmentParams params = new AssessmentParams(actions, currentLocation.getMetadata().getAmount());

        List<Feature> suitableCashMachines = new ArrayList<>();
        String jsonValue = geoJson.block();
        List<Feature> cashMachines = mapper.map(jsonValue);
        if (cashMachines.size() > 0) {
            for (Feature cashMachine : cashMachines) {
                List<Double> coordinates = cashMachine.getGeometry().getCoordinates();
                Assessment result = assesser.getAssessment(coordinates, params);

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

        // ПОКА ПРОСТО ОТДАЕМ ЕГО В ИСХОДНОМ ВИДЕ
        return resultCashMachines;

    }

}
