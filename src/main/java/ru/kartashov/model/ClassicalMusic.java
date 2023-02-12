package ru.kartashov.model;

public class ClassicalMusic implements Music {

    private ClassicalMusic() {
        System.out.println("We are inside the constructor of ClassicalMusic class");
    }

    public void init() {
        System.out.println("We are inside the init method of ClassicalMusic class");
    }

    public static ClassicalMusic getClassicalMusic() {
        System.out.println("We are inside the factory-method of ClassicalMusic class");
        return new ClassicalMusic();
    }

    @Override
    public String getSong() {
        return "Summer by Vivaldi";
    }

    public void destroy() {
        System.out.println("We are inside the destroy method of ClassicalMusic class");
    }
}