package ru.vlsu.ispi.springproject.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.ispi.springproject.dto.BlacklistPersonDto;
import ru.vlsu.ispi.springproject.models.Chat;
import ru.vlsu.ispi.springproject.models.Person;
import ru.vlsu.ispi.springproject.services.ContactService;

import java.util.List;

@RestController
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @GetMapping("/blacklist")
    public String displayBlacklist(@RequestBody long personId, Model model) {
        List<BlacklistPersonDto> blockedUsers = contactService.getBlockedUsers(personId);
        model.addAttribute("blockedUsers", blockedUsers);
        return "/blacklist";
    }

    @PostMapping("/chats/{chatId}/block")
    public String blockContact(@RequestBody long personId, @RequestBody long blockedUserId) {
        return contactService.blockContact(personId, blockedUserId);
    }

    @PostMapping("/blacklist/unblock")
    public String unblockContact(@RequestBody long personId, @RequestBody long blockedUserId) {
        return contactService.unblockContact(personId, blockedUserId);
    }
}
