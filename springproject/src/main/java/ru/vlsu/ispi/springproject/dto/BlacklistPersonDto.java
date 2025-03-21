package ru.vlsu.ispi.springproject.dto;

import ru.vlsu.ispi.springproject.models.Person;

import java.time.LocalDate;

public class BlacklistPersonDto {
    private long personId;
    private String name;
    private String surname;
    private String email;

    public BlacklistPersonDto(Person person) {
        name = person.getName();
        surname = person.getSurname();
        email = person.getEmail();
    }

    public BlacklistPersonDto(long personId, String name, String surname, String email) {
        this.personId = personId;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public long getPersonId() {
        return personId;
    }
}
