package ru.kartashov;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringWebApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        MusicPlayer musicPlayer1 = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer musicPlayer2 = context.getBean("musicPlayer", MusicPlayer.class);

        System.out.println(musicPlayer1 == musicPlayer2);
        System.out.println(musicPlayer1);
        System.out.println(musicPlayer2);

        System.out.println(musicPlayer1.getVolume());
        System.out.println(musicPlayer2.getVolume());

        musicPlayer1.setVolume(10);

        System.out.println(musicPlayer1.getVolume());
        System.out.println(musicPlayer2.getVolume());

        context.close();
    }
}
