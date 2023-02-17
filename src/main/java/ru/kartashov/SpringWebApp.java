package ru.kartashov;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kartashov.computer.music.Music;
import ru.kartashov.computer.music.MusicPlayer;

public class SpringWebApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println(musicPlayer.playMusic());

        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());

        Music classicalMusic1 = context.getBean("classicalMusic", Music.class);
        Music classicalMusic2 = context.getBean("classicalMusic", Music.class);

        System.out.println("Have singleton beans the same address? - " + (classicalMusic1 == classicalMusic2));

        Music rockMusic1 = context.getBean("rockMusic", Music.class);
        Music rockMusic2 = context.getBean("rockMusic", Music.class);

        System.out.println("Have prototype beans the same address? - " + (rockMusic1 == rockMusic2));

        context.close();
    }
}
