package ru.kartashov.computer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kartashov.computer.music.MusicPlayer;
import ru.kartashov.computer.music.MusicType;

@Component
public class Computer {

    private final int id;
    private final MusicPlayer musicPlayer;

    @Autowired
    public Computer(MusicPlayer musicPlayer) {
        id = 1;
        this.musicPlayer = musicPlayer;
    }

    @Override
    public String toString() {
        return "Computer " + id + " doing job: " + musicPlayer.playMusic(MusicType.ROCK);
    }
}