package de.jonashackt.springbootvuejs.service;

import de.jonashackt.springbootvuejs.model.Assessment;
import de.jonashackt.springbootvuejs.model.AssessmentParams;
import de.jonashackt.springbootvuejs.model.gsonobject.yandex.GeoJsonObject;

import java.util.List;

/**
 * Интерфейс для определения состояния доступности(чего-либо еще) для банкоматов
 * @author aleksandr
 * @date 2019-01-26 20:36
 */
public interface ICashMachineAssesser {

    /**
     * Оценить, удовлетворяет ли параметрам оценки банкомат или нет
     * @param machines Координаты банкомата
     * @param params Признак снятия/пополнения и сумма
     * @return Оценка
     */
    Assessment getAssessment(List<Double> machines, AssessmentParams params);
}
