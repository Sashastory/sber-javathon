package de.jonashackt.springbootvuejs.service;

import de.jonashackt.springbootvuejs.model.GsonObject;

/**
 * @author aleksandr
 * @date 2019-01-26 18:35
 */
public interface ICoordinatesResolver {

    /**
     *
     * @param currentLocation GsonObject объект текущей локации
     * @param type Тип локации - больница/школа/банкомат и т п
     * @return
     */
    GsonObject getCoordinates(GsonObject currentLocation, String type);

}
