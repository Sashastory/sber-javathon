package ru.javathon.springbootvuejs.service;

import ru.javathon.springbootvuejs.model.gsonobject.GsonObject;
import ru.javathon.springbootvuejs.model.gsonobject.yandex.Feature;
import ru.javathon.springbootvuejs.model.gsonobject.yandex.GeoJsonObject;

/**
 * @author aleksandr
 * @date 2019-01-27 06:50
 */
public abstract class AbstractServiceScorer {

    protected ICashMachineAssesser assesser;

    protected ICoordinatesResolver coordinatesResolver;

    protected IMapper<Feature> mapper;

    public AbstractServiceScorer(ICashMachineAssesser assesser, ICoordinatesResolver coordinatesResolver,
                                 IMapper<Feature> mapper) {
        this.assesser = assesser;
        this.coordinatesResolver = coordinatesResolver;
        this.mapper = mapper;
    }

    public abstract GeoJsonObject getCashMachines(GsonObject currentLocation);
}
