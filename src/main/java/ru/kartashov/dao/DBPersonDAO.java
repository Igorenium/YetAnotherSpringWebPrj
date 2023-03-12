package ru.kartashov.dao;

import org.springframework.stereotype.Component;
import ru.kartashov.dao.generator.IdGenerator;
import ru.kartashov.model.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBPersonDAO implements PersonDAO {

    private final Connection connection;
    private final IdGenerator idGenerator;

    public DBPersonDAO(Connection connection, IdGenerator idGenerator) {
        this.connection = connection;
        this.idGenerator = idGenerator;
    }

    @Override
    public List<Person> getPeople() {
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM person ORDER BY id");
            while(result.next()) {
                Person person = new Person();
                person.setId(result.getInt("id"));
                person.setName(result.getString("name"));
                person.setAge(result.getInt("age"));
                person.setEmail(result.getString("email"));
                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

    @Override
    public Person getPerson(int id) {
        Person person = new Person();
        try {
            Statement statement =  connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM person WHERE id = " + id);
            if (result.next()) {
                person.setId(result.getInt("id"));
                person.setName(result.getString("name"));
                person.setAge(result.getInt("age"));
                person.setEmail(result.getString("email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    @Override
    public void save(Person person) {
        person.setId(idGenerator.next());
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO person VALUES("
                    + person.getId() + ", '"
                    + person.getName() + "', "
                    + person.getAge() + ", '"
                    + person.getEmail() + "')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int id, Person person) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE person SET name = " + "'" + person.getName() + "', "
                    + "age = " + person.getAge() + ", "
                    + "email = " + "'" + person.getEmail() + "' "
                    + "WHERE id = " + person.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM person WHERE id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}