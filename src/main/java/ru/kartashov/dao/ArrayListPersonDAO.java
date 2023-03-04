package ru.kartashov.dao;

import org.springframework.stereotype.Component;
import ru.kartashov.dao.generator.IdGenerator;
import ru.kartashov.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArrayListPersonDAO implements PersonDAO {

    private final IdGenerator idGenerator;

    private final List<Person> people;

    public ArrayListPersonDAO(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;

        people = new ArrayList<>();
        people.add(new Person(idGenerator.next(), "Ann"));
        people.add(new Person(idGenerator.next(), "Boris"));
        people.add(new Person(idGenerator.next(), "Nick"));
        people.add(new Person(idGenerator.next(), "Fed"));
        people.add(new Person(idGenerator.next(), "Van"));
    }

    @Override
    public List<Person> getPeople() {
        return people;
    }

    @Override
    public Person getPerson(int id) {
        return people.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(Person person) {
        person.setId(idGenerator.next());
        people.add(person);
    }
}
