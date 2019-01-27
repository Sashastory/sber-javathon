package de.jonashackt.springbootvuejs.service.impl;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author aleksandr
 * @date 2019-01-27 07:33
 */
@Service
public class RandomBooleanReturner {

    public boolean returnBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
