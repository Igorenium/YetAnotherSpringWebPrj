package ru.kartashov.dao;

import ru.kartashov.model.Person;

import java.util.List;

public interface PersonDAO {

    List<Person> getPeople();

    Person getPerson(int id);

    void save(Person person);

    void update(int id, Person person);

    void delete(int id);
}
