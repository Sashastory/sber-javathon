package de.jonashackt.springbootvuejs.controller;

import de.jonashackt.springbootvuejs.model.gsonobject.GsonObject;
import de.jonashackt.springbootvuejs.service.impl.CashMachineTestService;
import de.jonashackt.springbootvuejs.service.impl.ExpertSystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    public static final String MOCK_RESOURCE = "Mock resource";

    private ExpertSystemService expertSystemService;

    private CashMachineTestService cashMachineTestService;

    public MainController(ExpertSystemService expertSystemService, CashMachineTestService testService) {
        this.expertSystemService = expertSystemService;
        this.cashMachineTestService = testService;
    }

    @PostMapping(path = "/cashMachines", produces = "application/json")
    public @ResponseBody String getCashMachines(@RequestBody GsonObject body) {
        LOG.info(body.toString());
        return expertSystemService.getCashMachines(body);
    }

    @PostMapping(path = "/testCashMachines")
    public @ResponseBody GsonObject getTestAtms(@RequestBody GsonObject body) {
        GsonObject testGson = cashMachineTestService.getTestGson();
        LOG.info(body.toString());
        LOG.info(testGson.toString());
        return testGson;
    }



}
