package ru.vlsu.ispi.springproject.dto;


import ru.vlsu.ispi.springproject.models.Person;

import java.time.LocalDate;

public class PersonDto {
    private String name;
    private String surname;
    private LocalDate birthday;
    private String email;
    private String passwordHash;

    public PersonDto(String name, String surname, LocalDate birthday, String email, String passwordHash) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public PersonDto(Person person) {
        this.name = person.getName();
        this.surname = person.getSurname();
        this.birthday = person.getBirthday();
        this.email = person.getEmail();
        this.passwordHash = person.getPasswordHash();
    }

    public Person ToPerson() {
        return new Person(
                0L,
                this.name,
                this.surname,
                this.birthday,
                this.email,
                this.passwordHash
        );
    }


    public LocalDate getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }


    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
