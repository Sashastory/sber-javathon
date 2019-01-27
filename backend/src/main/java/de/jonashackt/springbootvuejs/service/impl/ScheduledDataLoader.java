package de.jonashackt.springbootvuejs.service.impl;

import de.jonashackt.springbootvuejs.repository.GeoJsonObjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ScheduledDataLoader {

    private Logger logger = LoggerFactory.getLogger(ScheduledDataLoader.class);

    private GeoJsonToAtmMapper mapper;
    private YandexMapsCoordinatesResolver resolver;
    private GeoJsonObjectRepository repository;

    @Autowired
    public void setMapper(GeoJsonToAtmMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setResolver(YandexMapsCoordinatesResolver resolver) {
        this.resolver = resolver;
    }

    @Autowired
    public void setRepository(GeoJsonObjectRepository repository) {
        this.repository = repository;
    }

    @Scheduled(fixedRateString = "${scheduler.fixedRate}")
    public void scheduleFixedRateTask() {
        logger.info("started scheduled loading...");

        repository.deleteAll();
        Mono<String> search = resolver.search("Москва", "банкоматы Сбербанк");
        mapper.map(search.block());
    }
}
