package ru.kartashov.computer.music;

import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music {

    @Override
    public String getSong() {
        return "Перемен Виктора Цоя";
    }
}