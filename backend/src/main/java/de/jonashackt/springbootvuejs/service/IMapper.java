package de.jonashackt.springbootvuejs.service;

import java.util.List;

/**
 * Интерфейс для маппинга GeoJson в список желаемых объемов
 * @author aleksandr
 * @date 2019-01-26 22:30
 */
public interface IMapper<T> {
    List<T> map(String geoJson);
}
