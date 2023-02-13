package ru.kartashov;

import ru.kartashov.model.Music;

public class MusicPlayer {

    private Music music;

    public void setMusic(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing " + music.getSong());
    }
}