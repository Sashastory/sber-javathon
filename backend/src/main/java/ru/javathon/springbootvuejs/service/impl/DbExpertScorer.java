package ru.javathon.springbootvuejs.service.impl;

import ru.javathon.springbootvuejs.model.gsonobject.GsonObject;
import ru.javathon.springbootvuejs.model.gsonobject.yandex.Feature;
import ru.javathon.springbootvuejs.model.gsonobject.yandex.GeoJsonObject;
import ru.javathon.springbootvuejs.repository.GeoJsonObjectRepository;
import ru.javathon.springbootvuejs.service.AbstractServiceScorer;
import ru.javathon.springbootvuejs.service.ICashMachineAssesser;
import ru.javathon.springbootvuejs.service.ICoordinatesResolver;
import ru.javathon.springbootvuejs.service.IMapper;

import java.util.List;

/**
 * Сервис для оценки банкоматов использующий БД
 * @author aleksandr
 * @date 2019-01-27 06:58
 */
//@Service
public class DbExpertScorer extends AbstractServiceScorer {

    private GeoJsonObjectRepository repository;

    public DbExpertScorer(ICashMachineAssesser assesser, ICoordinatesResolver coordinatesResolver,
                          IMapper<Feature> mapper, GeoJsonObjectRepository repository) {
        super(assesser, coordinatesResolver, mapper);
        this.repository = repository;
    }

    @Override
    public GeoJsonObject getCashMachines(GsonObject currentLocation) {

        //TODO: Реализовать поиск из БД
        List<ru.javathon.springbootvuejs.model.gsonobject.Feature> features = currentLocation.getFeatures();
        return null;
    }
}
