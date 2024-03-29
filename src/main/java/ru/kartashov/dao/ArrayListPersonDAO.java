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
        people.add(new Person(idGenerator.next(), "Ann", "ann@mail.ru", 10));
        people.add(new Person(idGenerator.next(), "Boris", "boris@mail.ru", 20));
        people.add(new Person(idGenerator.next(), "Nick", "nick@mail.ru", 30));
        people.add(new Person(idGenerator.next(), "Kristina", "kris_fom_93@yandex.tu", 29));
        people.add(new Person(idGenerator.next(), "Van", "van@mail.ru", 40));
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

    @Override
    public void update(int id, Person refPerson) {
        Person updatedPerson = getPerson(id);
        updatedPerson.setName(refPerson.getName());
        updatedPerson.setEmail(refPerson.getEmail());
        updatedPerson.setAge(refPerson.getAge());
    }

    @Override
    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
