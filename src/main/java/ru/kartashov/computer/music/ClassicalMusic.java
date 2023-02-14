package ru.kartashov.computer.music;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music {

    @Override
    public String getSong() {
        return "Summer by Vivaldi";
    }
}