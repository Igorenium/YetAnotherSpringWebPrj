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
        people.add(new Person(idGenerator.next(), "Ann", "ann@mail.ru", "@annone"));
        people.add(new Person(idGenerator.next(), "Boris", "boris@mail.ru", "@boristwo"));
        people.add(new Person(idGenerator.next(), "Nick", "nick@mail.ru", "@nickthree"));
        people.add(new Person(idGenerator.next(), "Kristina", "kris_fom_93@yandex.tu", "@kristinfour"));
        people.add(new Person(idGenerator.next(), "Van", "van@mail.ru", "@vanfive"));
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
