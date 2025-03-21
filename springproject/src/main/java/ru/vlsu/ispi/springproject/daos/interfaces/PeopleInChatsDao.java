package ru.vlsu.ispi.springproject.daos.interfaces;

import java.util.List;

public interface PeopleInChatsDao {
    void addPersonInChat(long personId, long chatId);
    List<Long> getAllPeopleIdInChat(long chatId);
    List<Long> getAllChatIdByPersonId(long personId);
    void deletePersonFromChat(long personId, long chatId);
}
