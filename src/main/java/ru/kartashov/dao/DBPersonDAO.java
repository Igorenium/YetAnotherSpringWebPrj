package ru.kartashov.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.kartashov.dao.generator.IdGenerator;
import ru.kartashov.model.Person;

import java.util.List;

@Component
public class DBPersonDAO implements PersonDAO {

    private final JdbcTemplate jdbcTemplate;
    private final IdGenerator idGenerator;

    public DBPersonDAO(JdbcTemplate jdbcTemplate, IdGenerator idGenerator) {
        this.jdbcTemplate = jdbcTemplate;
        this.idGenerator = idGenerator;
    }

    @Override
    public List<Person> getPeople() {
        return jdbcTemplate.query("SELECT * FROM person ORDER BY id", new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public Person getPerson(int id) {
        return jdbcTemplate.query("SELECT * FROM person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    @Override
    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person VALUES(?, ?, ?, ?)",
                idGenerator.next(), person.getName(), person.getAge(), person.getEmail());
    }

    @Override
    public void update(int id, Person person) {
        jdbcTemplate.update("UPDATE person SET name=?, age=?, email=? WHERE id=?",
                person.getName(), person.getAge(), person.getEmail(), id);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
    }
}