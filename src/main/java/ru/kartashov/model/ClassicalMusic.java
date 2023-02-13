package ru.kartashov.model;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music {

    @Override
    public String getSong() {
        return "Summer by Vivaldi";
    }
}