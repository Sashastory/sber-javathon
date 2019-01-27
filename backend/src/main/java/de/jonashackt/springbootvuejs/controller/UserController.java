package de.jonashackt.springbootvuejs.controller;

import de.jonashackt.springbootvuejs.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public User main(@AuthenticationPrincipal User user) {
        LOG.info(user.toString());
        return user;
    }
}
