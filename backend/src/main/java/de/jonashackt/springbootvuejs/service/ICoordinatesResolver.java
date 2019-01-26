package de.jonashackt.springbootvuejs.service;

import de.jonashackt.springbootvuejs.model.GsonObject;
import reactor.core.publisher.Mono;

/**
 * @author aleksandr
 * @date 2019-01-26 18:35
 */
public interface ICoordinatesResolver {

    /**
     *
     * @param currentLocation GsªonObject объект текущей локации
     * @param type Тип локации - больница/школа/банкомат и т п
     * @return
     */
    Mono<GsonObject> getCoordinates(GsonObject currentLocation, String type);

}
