package ru.kartashov;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.kartashov.computer.music.ClassicalMusic;
import ru.kartashov.computer.music.Music;
import ru.kartashov.computer.music.MusicPlayer;
import ru.kartashov.computer.music.RockMusic;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("ru.kartashov")
@PropertySource("classpath:SpringWebApp.properties")
public class Config {

    @Bean
    public Music classicalMusic() {
        return new ClassicalMusic();
    }

    @Bean
    public RockMusic rockMusic() {
        return new RockMusic();
    }

    @Bean
    public List<Music> musicList() {
        List<Music> musicList = new ArrayList<>();
        musicList.add(classicalMusic());
        musicList.add(rockMusic());
        return musicList;
    }

    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(musicList());
    }
}