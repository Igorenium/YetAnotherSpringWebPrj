package ru.kartashov.model;

public class RockMusic implements Music {

    private RockMusic() {
        System.out.println("We are inside the constructor of RockMusic class");
    }

    public void init() {
        System.out.println("We are inside the init method of RockMusic class");
    }

    public static RockMusic getRockMusic() {
        System.out.println("We are inside the factory-method of RockMusic class");
        return new RockMusic();
    }

    @Override
    public String getSong() {
        return "Перемен Виктора Цоя";
    }

    public void destroy() {
        System.out.println("We are inside the destroy method of RockMusic class");
    }
}