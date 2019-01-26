package de.jonashackt.springbootvuejs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    public static final String MOCK_RESOURCE = "Mock resource";

    @PostMapping(path = "/atms")
    public @ResponseBody String getAtms(@RequestBody String body) {
        LOG.info(body);
        return MOCK_RESOURCE;
    }


}
