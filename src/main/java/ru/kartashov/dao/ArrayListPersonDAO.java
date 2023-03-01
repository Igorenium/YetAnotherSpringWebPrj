package ru.kartashov.dao;

import org.springframework.stereotype.Component;
import ru.kartashov.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArrayListPersonDAO implements PersonDAO {

    private final List<Person> people;
    private static int index;

    {
        people = new ArrayList<>();
        people.add(new Person(++index, "Ann"));
        people.add(new Person(++index, "Boris"));
        people.add(new Person(++index, "Nick"));
        people.add(new Person(++index, "Fed"));
        people.add(new Person(++index, "Van"));
    }

    @Override
    public List<Person> getPeople() {
        return people;
    }

    @Override
    public Person getPerson(int id) {
        return people.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }
}
