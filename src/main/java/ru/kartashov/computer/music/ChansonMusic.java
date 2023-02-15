package ru.kartashov.computer.music;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChansonMusic implements Music {

    private final List<String> songs;

    {
        songs = new ArrayList<>();
        songs.add("Бутырка Малец");
        songs.add("Бутырка Икона");
        songs.add("Бутырка Шарик");
        songs.add("Бутырка ЗАпахло весной");
    }

    @Override
    public List<String> getSongs() {
        return songs;
    }
}