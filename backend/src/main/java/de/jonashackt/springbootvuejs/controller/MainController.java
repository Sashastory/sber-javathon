package de.jonashackt.springbootvuejs.controller;

import com.google.gson.Gson;
import de.jonashackt.springbootvuejs.model.gsonobject.GsonObject;
import de.jonashackt.springbootvuejs.model.gsonobject.yandex.GeoJsonObject;
import de.jonashackt.springbootvuejs.service.AbstractServiceScorer;
import de.jonashackt.springbootvuejs.service.impl.CashMachineTestService;
import de.jonashackt.springbootvuejs.service.impl.DirectExpertScorer;
import de.jonashackt.springbootvuejs.service.impl.RandomBooleanReturner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    public static final String MOCK_RESOURCE = "Mock resource";

    private AbstractServiceScorer serviceScorer;

    private CashMachineTestService cashMachineTestService;

    private RandomBooleanReturner booleanReturner;

    private Gson GSON = new Gson();

    public MainController(DirectExpertScorer directExpertService, CashMachineTestService testService,
                          RandomBooleanReturner booleanReturner) {
        this.serviceScorer = directExpertService;
        this.cashMachineTestService = testService;
        this.booleanReturner = booleanReturner;
    }

    @PostMapping(path = "/cashMachines", produces = "application/json")
    public @ResponseBody GeoJsonObject getCashMachines(@RequestBody GsonObject body) {
        LOG.info(body.toString());
        return serviceScorer.getCashMachines(body);
    }

    @PostMapping(path = "/testCashMachines")
    public @ResponseBody GsonObject getTestAtms(@RequestBody GsonObject body) {
        GsonObject testGson = cashMachineTestService.getTestGson();
        LOG.info(body.toString());
        LOG.info(testGson.toString());
        return testGson;
    }

    @GetMapping(path = "/boolean", produces = "application/json")
    public String getRandomBoolean() {
        boolean b = booleanReturner.returnBoolean();
        return GSON.toJson(Collections.singletonMap("value", b));
    }



}
