package ru.vlsu.ispi.springproject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.ispi.springproject.dto.AccountSettingsRequestDto;
import ru.vlsu.ispi.springproject.dto.AuthRequestDto;
import ru.vlsu.ispi.springproject.dto.PasswordUpdateRequestDto;
import ru.vlsu.ispi.springproject.dto.RegistrationRequestDto;
import ru.vlsu.ispi.springproject.services.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PutMapping("/settings")
    public String updateAccountSettings(@RequestBody AccountSettingsRequestDto request) {
        return accountService.updateAccountSettings(request);
    }

    @PostMapping("/logout")
    public String logout() {
        return accountService.logout();
    }

    @PostMapping("/auth")
    public String authenticate(@RequestBody AuthRequestDto authRequest) {
        return accountService.authenticate(authRequest);
    }

    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequestDto registrationRequest) {
        return accountService.register(registrationRequest);
    }

    @PutMapping("/password")
    public String updatePassword(@RequestBody PasswordUpdateRequestDto request) {
        return accountService.updatePassword(request);
    }
}
