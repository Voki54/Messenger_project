package ru.vlsu.ispi.springproject.daos.implementations;


import ru.vlsu.ispi.springproject.models.Person;
import ru.vlsu.ispi.springproject.daos.interfaces.PersonDao;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {
    private final DataSource dataSource;
    
    public PersonDaoImpl (DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void addPerson(Person person) {
        String query = "INSERT INTO person (name, surname, birthday, email, password_hash) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query)) {
            statement.setString(1, person.getName());
            statement.setString(2, person.getSurname());
            statement.setDate(3, java.sql.Date.valueOf(person.getBirthday()));
            statement.setString(4, person.getEmail());
            statement.setString(5, person.getPasswordHash());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error addPerson: " + e.getMessage());
        }
    }

    @Override
    public void updatePerson(Person person) {
        String query = "UPDATE person SET name = ?, surname = ?, birthday = ?, email = ?, password_hash = ? WHERE id = ?";

        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query)) {
            statement.setString(1, person.getName());
            statement.setString(2, person.getSurname());
            statement.setDate(3, java.sql.Date.valueOf(person.getBirthday()));
            statement.setString(4, person.getEmail());
            statement.setString(5, person.getPasswordHash());
            statement.setLong(6, person.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updatePerson: " + e.getMessage());
        }
    }

    @Override
    public void deletePerson(long personId) {
        String query = "DELETE FROM person WHERE id = ?";
        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query)) {
            statement.setLong(1, personId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deletePerson: " + e.getMessage());
        }
    }

    @Override
    public Person getPersonById(long personId) {
        String query = "SELECT name, surname, birthday, email, password_hash FROM person WHERE id = ?";
        Person person = null;

        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query)) {
            statement.setLong(1, personId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    person = new Person(
                            personId,
                            resultSet.getString("name"),
                            resultSet.getString("surname"),
                            resultSet.getDate("birthday").toLocalDate(),
                            resultSet.getString("email"),
                            resultSet.getString("password_hash")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error getPersonById: " + e.getMessage());
        }
        return person;
    }

    @Override
    public Person getPersonByEmail(String email) {
        String query = "SELECT id, name, surname, birthday, password_hash FROM person WHERE email = ?";
        Person person = null;

        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    person = new Person(
                            resultSet.getLong("id"),
                            resultSet.getString("name"),
                            resultSet.getString("surname"),
                            resultSet.getDate("birthday").toLocalDate(),
                            email,
                            resultSet.getString("password_hash")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error getPersonById: " + e.getMessage());
        }
        return person;
    }

    @Override
    public List<Person> getAllPeople() {
        String query = "SELECT * FROM person";
        ArrayList<Person> people = new ArrayList<>();

        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Person person = new Person(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getDate("birthday").toLocalDate(),
                        resultSet.getString("email"),
                        resultSet.getString("password_hash")
                );
                people.add(person);
            }
        } catch (SQLException e) {
            System.out.println("Error getAllPeople: " + e.getMessage());
        }
        return people;
    }
}