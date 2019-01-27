package de.jonashackt.springbootvuejs.service.impl;

import de.jonashackt.springbootvuejs.model.gsonobject.GsonObject;
import de.jonashackt.springbootvuejs.model.CashMachine;
import de.jonashackt.springbootvuejs.service.ICashMachineAssesser;
import de.jonashackt.springbootvuejs.service.ICoordinatesResolver;
import de.jonashackt.springbootvuejs.service.IMapper;
import org.springframework.stereotype.Service;

/**
 * @author aleksandr
 * @date 2019-01-26 20:58
 */
@Service
public class ExpertSystemService {

    private ICashMachineAssesser assesser;

    private ICoordinatesResolver coordinatesResolver;

    private IMapper<CashMachine> mapper;

    public GsonObject getCashMachines(GsonObject currentLocation) {
        // ПОЛУЧАЕМ GEOJSON С БАНКОМАТАМИ

        // МАПИМ ЕГО В БАНКОМАТЫ И СОХРАНЯЕМ ИХ В БД

        // ОЦЕНИВАЕМ ЯКОБЫ СБЕРОМ ДОСТУПНЫ ЛИ БАНКОМАТЫ
        // ОНИ КЛАДУТ ТОГГЛ В ПОЛЕ ДЕСКРИПШН

        return null;

    }

}
