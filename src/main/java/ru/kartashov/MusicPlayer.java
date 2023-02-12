package ru.kartashov;

import ru.kartashov.model.Music;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {

    private List<Music> musicList = new ArrayList<>();

    private String name;
    private int volume;

    public MusicPlayer() {
        System.out.println("We are inside the constructor of MusicPlayer class");
    }

    public void init() {
        System.out.println("We are inside the init method of MusicPlayer class");
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
        System.out.println("We are setting musicList field");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public void playMusic() {
        musicList.forEach(m -> System.out.println("Playing " + m.getSong()));
    }

    public void destroy() {
        System.out.println("We are inside the destroy method of MusicPlayer class");
    }
}