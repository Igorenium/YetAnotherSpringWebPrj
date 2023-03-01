package ru.kartashov.dao;

import ru.kartashov.model.Person;

import java.util.List;

public interface PersonDAO {

    List<Person> getPeople();

    Person getPerson(int id);
}
