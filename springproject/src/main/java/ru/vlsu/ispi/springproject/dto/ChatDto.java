package ru.vlsu.ispi.springproject.dto;

import ru.vlsu.ispi.springproject.models.Chat;

public class ChatDto {
    private String name;

    public ChatDto(String name) {
        this.name = name;
    }

    public ChatDto(Chat chat) {
        this.name = chat.getName();
    }

    public Chat ToChat(){
        return new Chat(0L, this.getName());
    }

    public String getName() {
        return name;
    }
}
