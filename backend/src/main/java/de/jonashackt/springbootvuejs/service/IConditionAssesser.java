package de.jonashackt.springbootvuejs.service;

/**
 * Интерфейс для определения состояния доступности(чего-либо еще) для объекта
 * @author aleksandr
 * @date 2019-01-26 20:36
 */
public interface IConditionAssesser<T> {

    String getAssessment(T object);
}
