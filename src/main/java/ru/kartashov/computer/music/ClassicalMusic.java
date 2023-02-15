package ru.kartashov.computer.music;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassicalMusic implements Music {

    private final List<String> songs;

    {
        songs = new ArrayList<>();
        songs.add("Vivaldi Summer");
        songs.add("Vivaldi Winter");
        songs.add("Vivaldi Autumn");
        songs.add("Vivaldi Spring");
    }

    @Override
    public List<String> getSongs() {
        return songs;
    }
}