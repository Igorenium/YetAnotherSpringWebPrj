package ru.kartashov;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kartashov.model.Music;

public class SpringWebApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        Music music = context.getBean("chansonMusic", Music.class);
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.setMusic(music);
        musicPlayer.playMusic();

        context.close();
    }
}
