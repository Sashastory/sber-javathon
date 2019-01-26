package de.jonashackt.springbootvuejs.service;

import com.google.gson.Gson;
import org.springframework.util.MultiValueMap;
import reactor.core.publisher.Mono;

/**
 * @author aleksandr
 * @date 2019-01-26 18:35
 */
public interface ICoordinatesResolver {

    /**
     * Получение GsonObject по определенным параметрам
     * @param params
     * @return
     */
    Mono<Gson> search(MultiValueMap<String, String> params);

}
