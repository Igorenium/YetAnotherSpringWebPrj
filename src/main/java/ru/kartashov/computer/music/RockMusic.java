package ru.kartashov.computer.music;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RockMusic implements Music {

    private final List<String> songs;

    {
        songs = new ArrayList<>();
        songs.add("AC DC TNT");
        songs.add("AC DC Shoot to thrill");
        songs.add("AC DC Thunder");
        songs.add("AC DC Black in black");
    }

    @Override
    public List<String> getSongs() {
        return songs;
    }
}