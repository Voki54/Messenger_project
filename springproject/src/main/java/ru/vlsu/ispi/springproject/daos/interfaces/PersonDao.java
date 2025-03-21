package ru.vlsu.ispi.springproject.daos.interfaces;

import ru.vlsu.ispi.springproject.models.Person;

import java.util.List;

public interface PersonDao {
    void addPerson(Person person);
    Person getPersonById(long id);
    Person getPersonByEmail(String email);
    List<Person> getAllPeople();
    void updatePerson(Person person);
    void deletePerson(long id);
}
