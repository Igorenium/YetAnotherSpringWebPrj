package ru.kartashov.computer.music;

import org.springframework.stereotype.Component;

@Component
public class ChansonMusic implements Music {

    @Override
    public String getSong() {
        return "Малец группы Бутырка";
    }
}