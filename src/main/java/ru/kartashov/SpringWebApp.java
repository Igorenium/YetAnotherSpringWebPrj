package ru.kartashov;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kartashov.model.Music;

public class SpringWebApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        Music music = context.getBean("musicBean", Music.class);
        new MusicPlayer(music).playMusic();

        context.close();
    }
}
