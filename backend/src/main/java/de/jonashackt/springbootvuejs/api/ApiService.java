package de.jonashackt.springbootvuejs.api;

import com.google.gson.Gson;
import org.springframework.util.MultiValueMap;
import reactor.core.publisher.Mono;

public interface ApiService {

    Mono<Gson> search(MultiValueMap<String, String> params);

}
