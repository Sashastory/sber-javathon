package ru.javathon.springbootvuejs.service.impl;

import ru.javathon.springbootvuejs.model.Action;
import ru.javathon.springbootvuejs.model.Assessment;
import ru.javathon.springbootvuejs.model.AssessmentParams;
import ru.javathon.springbootvuejs.model.gsonobject.GsonObject;
import ru.javathon.springbootvuejs.model.gsonobject.yandex.Feature;
import ru.javathon.springbootvuejs.model.gsonobject.yandex.GeoJsonObject;
import ru.javathon.springbootvuejs.service.AbstractServiceScorer;
import ru.javathon.springbootvuejs.service.ICashMachineAssesser;
import ru.javathon.springbootvuejs.service.ICoordinatesResolver;
import ru.javathon.springbootvuejs.service.IMapper;
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

        return resultCashMachines;

    }

}
