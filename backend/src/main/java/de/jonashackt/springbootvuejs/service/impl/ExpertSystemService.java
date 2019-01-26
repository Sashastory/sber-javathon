package de.jonashackt.springbootvuejs.service.impl;

import de.jonashackt.springbootvuejs.model.gsonobject.GsonObject;
import de.jonashackt.springbootvuejs.model.CashMachine;
import de.jonashackt.springbootvuejs.service.ICashMachineAssesser;
import de.jonashackt.springbootvuejs.service.ICoordinatesResolver;
import de.jonashackt.springbootvuejs.service.IMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author aleksandr
 * @date 2019-01-26 20:58
 */
@Service
public class ExpertSystemService {

    private ICashMachineAssesser assesser;

    private ICoordinatesResolver coordinatesResolver;

    public ExpertSystemService(ICashMachineAssesser assesser, ICoordinatesResolver coordinatesResolver) {
        this.assesser = assesser;
        this.coordinatesResolver = coordinatesResolver;
    }

    public String getCashMachines(GsonObject currentLocation) {
        // ПОЛУЧАЕМ GEOJSON С БАНКОМАТАМИ
        Mono<String> geoJson = coordinatesResolver.search(currentLocation, "банкоматы Сбербанка");

        // ОЦЕНИВАЕМ ЯКОБЫ СБЕРОМ ДОСТУПНЫ ЛИ БАНКОМАТЫ
        // ОНИ КЛАДУТ ТОГГЛ В ПОЛЕ ДЕСКРИПШН

        // МАПИМ ЕГО В БАНКОМАТЫ И СОХРАНЯЕМ ИХ В БД
        String jsonValue = geoJson.block();

        return jsonValue;

    }

}
