package ru.kartashov.computer.music;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer {

    private final Music music1;
    private final Music music2;
    private final Music music3;

    public MusicPlayer(@Qualifier("classicalMusic") Music music1,
                       @Qualifier("rockMusic") Music music2,
                       @Qualifier("chansonMusic") Music music3) {
        this.music1 = music1;
        this.music2 = music2;
        this.music3 = music3;
    }

    public String playMusic(MusicType musicType) {
        int rnd = new Random().nextInt(4);
        String song = "";
        switch (musicType) {
            case CLASSICAL:
                song = music1.getSongs().get(rnd);
                break;
            case ROCK:
                song = music2.getSongs().get(rnd);
                break;
            case CHANSON:
                song = music3.getSongs().get(rnd);
                break;
        }
        return "Playing " + song;
    }
}