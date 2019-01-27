package ru.javathon.springbootvuejs.service.impl;

import ru.javathon.springbootvuejs.model.Assessment;
import ru.javathon.springbootvuejs.model.AssessmentParams;
import ru.javathon.springbootvuejs.service.ICashMachineAssesser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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
        int boundary;

        if (score.getAmount() > 100000) {
            boundary = 4;
        } else {
            boundary = 10;
        }
        int b = random.nextInt(boundary);

        return b > 2 ? Assessment.SUITABLE : Assessment.NOT_SUITABLE;
    }
}
