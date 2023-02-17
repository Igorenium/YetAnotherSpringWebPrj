package ru.kartashov.computer.music;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class RockMusic implements Music {

    public RockMusic() {
        System.out.println("Inside CONSTRUCTOR of RockMusic bean");
    }

    @PostConstruct
    private void init() {
        System.out.println("Inside INIT method of RockMusic bean");
    }

    @Override
    public String getSong() {
        return "Цой";
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Inside DESTROY method of RockMusic bean");
    }
}