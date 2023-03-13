package ru.kartashov.dao;

import org.springframework.stereotype.Component;
import ru.kartashov.dao.generator.IdGenerator;
import ru.kartashov.model.Person;

import java.sql.*;
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
        Person person = null;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM person WHERE id=?");

            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                person = new Person();
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
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO person VALUES(?, ?, ?, ?)");

            preparedStatement.setInt(1, person.getId());
            preparedStatement.setString(2, person.getName());
            preparedStatement.setInt(3, person.getAge());
            preparedStatement.setString(4, person.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int id, Person person) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE person SET name=?, age=?, email=? WHERE id=?");

            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM person WHRER id=?");

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}