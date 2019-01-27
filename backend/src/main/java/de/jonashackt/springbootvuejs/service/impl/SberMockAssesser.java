package de.jonashackt.springbootvuejs.service.impl;

import de.jonashackt.springbootvuejs.model.Assessment;
import de.jonashackt.springbootvuejs.model.AssessmentParams;
import de.jonashackt.springbootvuejs.model.CashMachine;
import de.jonashackt.springbootvuejs.model.gsonobject.yandex.GeoJsonObject;
import de.jonashackt.springbootvuejs.service.ICashMachineAssesser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Заглушка для определения банкоматов по желаемому критерию оценки
 * @author aleksandr
 * @date 2019-01-26 23:47
 */
@Service
public class SberMockAssesser implements ICashMachineAssesser {

    @Override
    public Assessment getAssessment(List<Double> coordinates, AssessmentParams score) {

        Random random = new Random();
        boolean b = random.nextBoolean();

        return b ? Assessment.SUITABLE : Assessment.NOT_SUITABLE;
    }
}
