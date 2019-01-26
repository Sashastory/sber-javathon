package de.jonashackt.springbootvuejs.service.impl;

import de.jonashackt.springbootvuejs.model.AssessmentScore;
import de.jonashackt.springbootvuejs.model.CashMachine;
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
    public List<CashMachine> getAssessment(List<CashMachine> machines, AssessmentScore score) {

        List<CashMachine> result = null;

        switch (score) {

            case CAN_DEPOSIT: {

                Random random = new Random();
                int i = random.nextInt(machines.size());

                if (machines.size() != 0) {
                    result = machines.stream().skip(i).collect(Collectors.toList());
                }

                break;
            }

            case CAN_WITHDRAW: {

                Random random = new Random();
                int j = random.nextInt(machines.size());

                if (machines.size() != 0) {
                    result = machines.stream().filter(cm -> cm.getId() != j).collect(Collectors.toList());
                }
                break;
            }

            default:
                break;
        }

        return result;
    }
}
