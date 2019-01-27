package ru.javathon.springbootvuejs.service;

import ru.javathon.springbootvuejs.model.gsonobject.GsonObject;
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
     * @return ответ Yandex.Maps API в формате JSON
     */
    Mono<String> search(GsonObject current, String type);

}
