package ru.vlsu.ispi.springproject.services;

import ru.vlsu.ispi.springproject.daos.interfaces.PersonDao;
import ru.vlsu.ispi.springproject.dto.*;
import ru.vlsu.ispi.springproject.models.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountService {

    private final PersonDao personDao;

    public AccountService(PersonDao personDao){
        this.personDao = personDao;
    }

    public String updateAccountSettings(AccountSettingsRequestDto request) {
        Person person = personDao.getPersonByEmail(request.getEmail());
        if (person != null) {
            person.setName(request.getDisplayName());
            person.setEmail(request.getEmail());
            person.setBirthday(request.getBirthdayDate());
            personDao.updatePerson(person);
            return "/api/account/settings/";
        }
        return "/api/account";
    }

    public String logout() {
        //Логика выхода из аккаунта
        return "/api";
    }

    public String authenticate(AuthRequestDto authRequest) {
        Person person = personDao.getPersonByEmail(authRequest.getEmail());
            if (person.getEmail().equals(authRequest.getEmail())
                    && person.getPasswordHash().equals(authRequest.getPassword())) {
                return "/api/chats/";
            }
        return "/api";
    }

    public String register(RegistrationRequestDto registrationRequest) {
        Person newPerson = new Person(registrationRequest.getDisplayName(),"",registrationRequest.getBirthdayDate(),registrationRequest.getEmail(),registrationRequest.getPassword());
        personDao.addPerson(newPerson);
        return "/api/chats";
    }

    public String updatePassword(PasswordUpdateRequestDto request) {
        Person person = personDao.getPersonById(request.getUserId());
        person.setPasswordHash(request.getNewPassword());
        personDao.updatePerson(person);
        return "/api/account";
    }
}
