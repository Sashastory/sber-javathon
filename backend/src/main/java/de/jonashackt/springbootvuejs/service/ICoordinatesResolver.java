package de.jonashackt.springbootvuejs.service;

import de.jonashackt.springbootvuejs.model.gsonobject.GsonObject;
import reactor.core.publisher.Mono;

/**
 * Интерфейс для определения координат объекта на основе текущей локации
 * @author aleksandr
 * @date 2019-01-26 18:35
 */
public interface ICoordinatesResolver {

    /**
     *
     * @param current GsonObject текущей локации
     * @param type Тип локации - банкомат/больница
     * @return
     */
    Mono<GsonObject> search(GsonObject current, String type);

}
