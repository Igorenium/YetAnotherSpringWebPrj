package ru.kartashov.computer.music;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ClassicalMusic implements Music {

    public ClassicalMusic() {
        System.out.println("Inside CONSTRUCTOR of ClassicalMusic bean");
    }

    @PostConstruct
    private void init() {
        System.out.println("Inside INIT method of ClassicalMusic bean");
    }

    @Override
    public String getSong() {
        return "Vivaldi";
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Inside DESTROY method of ClassicalMusic bean");
    }
}