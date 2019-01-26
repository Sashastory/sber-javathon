package de.jonashackt.springbootvuejs.service;

/**
 * Интерфейс для маппинга объекта в объект
 * @author aleksandr
 * @date 2019-01-26 22:30
 */
public interface IMapper<T, V> {

    T map(V object);
}
