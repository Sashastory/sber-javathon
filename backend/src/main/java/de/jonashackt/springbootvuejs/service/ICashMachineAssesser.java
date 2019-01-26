package de.jonashackt.springbootvuejs.service;

import de.jonashackt.springbootvuejs.model.AssessmentScore;
import de.jonashackt.springbootvuejs.model.CashMachine;

import java.util.List;

/**
 * Интерфейс для определения состояния доступности(чего-либо еще) для банкоматов
 * @author aleksandr
 * @date 2019-01-26 20:36
 */
public interface ICashMachineAssesser {

    List<CashMachine> getAssessment(AssessmentScore score);
}
