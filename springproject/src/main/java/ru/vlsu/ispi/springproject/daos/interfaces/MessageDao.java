package ru.vlsu.ispi.springproject.daos.interfaces;

import ru.vlsu.ispi.springproject.models.Message;

import java.util.List;

public interface MessageDao {
    void addMessage(Message message);
    Message getMessageById(long id);
    List<Message> getAllMessages();
    List<Message> getAllMessagesInChat(long chatId);
    void updateMessage(Message message);
    void deleteMessage(long id);
}
