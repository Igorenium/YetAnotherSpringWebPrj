package ru.kartashov.model;

public class ChansonMusic implements Music {

    private ChansonMusic() {
        System.out.println("We are inside the constructor of ChansonMusic class");
    }

    public void init() {
        System.out.println("We are inside the init method of ChansonMusic class");
    }

    public static ChansonMusic getChansonMusic() {
        System.out.println("We are inside the factory-method of ChansonMusic class");
        return new ChansonMusic();
    }

    @Override
    public String getSong() {
        return "Малец группы Бутырка";
    }

    public void destroy() {
        System.out.println("We are inside the destroy method of ChansonMusic class");
    }
}