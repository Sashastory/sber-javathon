package de.jonashackt.springbootvuejs.service.impl;

import de.jonashackt.springbootvuejs.model.gsonobject.GsonObject;
import de.jonashackt.springbootvuejs.model.gsonobject.yandex.Feature;
import de.jonashackt.springbootvuejs.model.gsonobject.yandex.GeoJsonObject;
import de.jonashackt.springbootvuejs.repository.GeoJsonObjectRepository;
import de.jonashackt.springbootvuejs.service.AbstractServiceScorer;
import de.jonashackt.springbootvuejs.service.ICashMachineAssesser;
import de.jonashackt.springbootvuejs.service.ICoordinatesResolver;
import de.jonashackt.springbootvuejs.service.IMapper;

/**
 * Сервис для оценки банкоматов использующий БД
 * @author aleksandr
 * @date 2019-01-27 06:58
 */
public class DbExpertScorer extends AbstractServiceScorer {

    private GeoJsonObjectRepository repository;

    public DbExpertScorer(ICashMachineAssesser assesser, ICoordinatesResolver coordinatesResolver,
                          IMapper<Feature> mapper, GeoJsonObjectRepository repository) {
        super(assesser, coordinatesResolver, mapper);
        this.repository = repository;
    }

    @Override
    public GeoJsonObject getCashMachines(GsonObject currentLocation) {
        return null;
    }
}
