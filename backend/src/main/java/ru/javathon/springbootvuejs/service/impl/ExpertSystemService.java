package ru.javathon.springbootvuejs.service.impl;

import ru.javathon.springbootvuejs.model.gsonobject.GsonObject;
import ru.javathon.springbootvuejs.service.ICashMachineAssesser;
import ru.javathon.springbootvuejs.service.ICoordinatesResolver;
import ru.javathon.springbootvuejs.service.IMapper;
import org.springframework.stereotype.Service;

/**
 * @author aleksandr
 * @date 2019-01-26 20:58
 */
@Service
public class ExpertSystemService {

    private ICashMachineAssesser assesser;

    private ICoordinatesResolver coordinatesResolver;

    private IMapper<String> mapper;

    public GsonObject getCashMachines(GsonObject currentLocation) {
        // ПОЛУЧАЕМ GEOJSON С БАНКОМАТАМИ

        // МАПИМ ЕГО В БАНКОМАТЫ И СОХРАНЯЕМ ИХ В БД

        // ОЦЕНИВАЕМ ЯКОБЫ СБЕРОМ ДОСТУПНЫ ЛИ БАНКОМАТЫ
        // ОНИ КЛАДУТ ТОГГЛ В ПОЛЕ ДЕСКРИПШН

        return null;

    }

}
