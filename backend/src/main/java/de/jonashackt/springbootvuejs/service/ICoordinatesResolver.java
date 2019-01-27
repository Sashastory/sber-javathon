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
     * @param location Название текущей локации
     * @param type Тип локации - банкомат/больница
     * @return ответ Yandex.Maps API в формате JSON
     */
    Mono<String> search(String location, String type);
}
