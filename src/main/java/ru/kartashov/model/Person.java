package ru.kartashov.model;

public class Person {

    private int id;
    private String name;
    private String email;
    private String instagram;

    public Person() {
    }

    public Person(int id, String name, String email, String instagram) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.instagram = instagram;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getInstagram() {
        return instagram;
    }
}
