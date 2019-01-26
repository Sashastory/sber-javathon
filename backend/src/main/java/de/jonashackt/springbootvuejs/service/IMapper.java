package de.jonashackt.springbootvuejs.service;

import java.util.List;

/**
 * Интерфейс для маппинга объекта в объект
 * @author aleksandr
 * @date 2019-01-26 22:30
 */
public interface IMapper<T, V> {

    List<T> map(V object);
}
