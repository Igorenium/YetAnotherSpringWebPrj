package ru.kartashov.model;

import javax.validation.constraints.*;

public class Person {

    private int id;

    @NotBlank( message = "Name shouldn't be blanc")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;

    @NotBlank(message = "Email shouldn't be blanc")
    @Email(message = "Email should be correct")
    private String email;

    @Min(value = 0, message = "Age should be greater than 0")
    private int age;

    public Person() {
    }

    public Person(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
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

    public void setAge(int age) {
        this.age = age;
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

    public int getAge() {
        return age;
    }
}
