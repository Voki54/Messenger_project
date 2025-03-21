package ru.vlsu.ispi.springproject.models;

import java.time.LocalDate;

public class Person {
    private long id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private String email;
    private String passwordHash;

    public Person(long id, String name, String surname, LocalDate birthday, String email, String passwordHash){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public Person(String name, String surname, LocalDate birthday, String email, String passwordHash){
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public long getId() {
        return id;
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

    public void setId(long id) {
        this.id = id;
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
}