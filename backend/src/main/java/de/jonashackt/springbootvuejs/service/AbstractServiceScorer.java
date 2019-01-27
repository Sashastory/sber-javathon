package de.jonashackt.springbootvuejs.service;

import de.jonashackt.springbootvuejs.model.gsonobject.GsonObject;
import de.jonashackt.springbootvuejs.model.gsonobject.yandex.Feature;
import de.jonashackt.springbootvuejs.model.gsonobject.yandex.GeoJsonObject;

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
