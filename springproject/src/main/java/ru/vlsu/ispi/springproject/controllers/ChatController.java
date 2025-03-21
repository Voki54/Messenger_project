package ru.vlsu.ispi.springproject.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.ispi.springproject.dto.ChatDto;
import ru.vlsu.ispi.springproject.models.Chat;
import ru.vlsu.ispi.springproject.models.Message;
import ru.vlsu.ispi.springproject.models.Person;
import ru.vlsu.ispi.springproject.services.ChatService;

import java.util.List;

@RestController
@RequestMapping("/chats")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/{\"\", /}")
    public String displayUserChats(@PathVariable Long personId, Model model) {
        List<Chat> chats = chatService.getChatsByPersonId(personId);
        model.addAttribute("members", chats);
        return "/chats";
    }

    @GetMapping("/{chatId}")
    public String displayChat(@PathVariable Long chatId, Model model) {
        List<Message> messages = chatService.getChatMessages(chatId);
        model.addAttribute("members", messages);
        return "/chats" + chatId;
    }

    @PostMapping("/create")
    public String createChat(@RequestBody ChatDto chatRequest) {
        return chatService.createChat(chatRequest);
    }

    @PostMapping("/{chatId}/add")
    public String addPersonToChat(@PathVariable Long chatId, @RequestBody Long personId) {
        return chatService.addPersonToChat(personId, chatId);
    }

    @PostMapping("/{chatId}/exit")
    public String exitChat(@PathVariable Long chatId, @RequestBody Long personId) {
        return chatService.exitChat(personId, chatId);
    }

    @GetMapping("/{chatId}/members")
    public String viewChatMembers(@PathVariable Long chatId, Model model) {
        List<Person> members = chatService.getChatMembers(chatId);
        model.addAttribute("chatId", chatId);
        model.addAttribute("members", members);
        return "/chats/" + chatId + "/members";
    }

    @PutMapping("/{chatId}/edit")
    public String editChat(@PathVariable Long chatId, @RequestBody ChatDto chatDto) {
        return chatService.editChat(chatId, chatDto);
    }

    @DeleteMapping("/{chatId}")
    public String deleteChat(@PathVariable Long chatId) {
        return chatService.deleteChat(chatId);
    }
}
