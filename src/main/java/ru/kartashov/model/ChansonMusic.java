package ru.kartashov.model;

import org.springframework.stereotype.Component;

@Component
public class ChansonMusic implements Music {

    @Override
    public String getSong() {
        return "Малец группы Бутырка";
    }
}