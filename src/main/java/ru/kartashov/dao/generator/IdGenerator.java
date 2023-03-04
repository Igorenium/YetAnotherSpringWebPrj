package ru.kartashov.dao.generator;

import org.springframework.stereotype.Component;

@Component
public class IdGenerator {

    private static int id;

    public int next() {
        return ++id;
    }
}