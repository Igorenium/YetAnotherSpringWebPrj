package ru.kartashov.computer.music;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
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