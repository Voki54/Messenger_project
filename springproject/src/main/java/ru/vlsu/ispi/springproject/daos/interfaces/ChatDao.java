package ru.vlsu.ispi.springproject.daos.interfaces;

import ru.vlsu.ispi.springproject.models.Chat;

import java.util.List;

public interface ChatDao {
    Chat addChat(Chat chat);
    Chat getChatById(long id);
    List<Chat> getAllChats();
    void updateChat(Chat chat);
    void deleteChat(long id);
}
