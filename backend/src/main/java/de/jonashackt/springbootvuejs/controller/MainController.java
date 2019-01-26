package de.jonashackt.springbootvuejs.controller;

import de.jonashackt.springbootvuejs.model.gsonobject.GsonObject;
import de.jonashackt.springbootvuejs.yandex.YandexMapsCoordinatesResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    public static final String MOCK_RESOURCE = "Mock resource";

    @PostMapping(path = "/atms")
    public @ResponseBody GsonObject getAtms(@RequestBody GsonObject body) {
        LOG.info(body.toString());
        return body;
    }


}
