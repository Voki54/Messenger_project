package ru.vlsu.ispi.springproject.services;

import ru.vlsu.ispi.springproject.daos.interfaces.MessageDao;
import ru.vlsu.ispi.springproject.dto.ChatDto;
import ru.vlsu.ispi.springproject.dto.ChatRequestDto;
import ru.vlsu.ispi.springproject.models.Chat;
import ru.vlsu.ispi.springproject.models.Message;
import ru.vlsu.ispi.springproject.models.Person;
import ru.vlsu.ispi.springproject.daos.interfaces.ChatDao;
import ru.vlsu.ispi.springproject.daos.interfaces.PeopleInChatsDao;
import ru.vlsu.ispi.springproject.daos.interfaces.PersonDao;

import java.util.ArrayList;
import java.util.List;

public class ChatService {
    private ChatDao chatDao;
    private PersonDao personDao;
    private PeopleInChatsDao peopleInChatsDao;
    private MessageDao messageDao;

    public ChatService(ChatDao chatDao, PersonDao personDao,
                       PeopleInChatsDao peopleInChatsDao, MessageDao messageDao) {
        this.chatDao = chatDao;
        this.personDao = personDao;
        this.peopleInChatsDao = peopleInChatsDao;
        this.messageDao = messageDao;
    }

    public String createChat(ChatDto chatDto) {
        Chat newChat = chatDao.addChat(chatDto.ToChat());
        if (newChat == null)
            return "";
        return "/api/chats/" + newChat.getId();
    }

    public String addPersonToChat(Long personId, Long chatId) {
        peopleInChatsDao.addPersonInChat(personId, chatId);
        return "/api/chats/" + chatId;
    }

    public String exitChat(long personId, long chatId) {
        peopleInChatsDao.deletePersonFromChat(personId, chatId);
        return "/api/chats";
    }

    public String editChat(long chatId, ChatDto chatDto) {
        Chat editableСhat = chatDao.getChatById(chatId);
        if (editableСhat == null)
            return "/api/chats/";
        editableСhat.setName(chatDto.getName());
        chatDao.updateChat(editableСhat);
        return "/api/chats/" + chatId;
    }

    public String deleteChat(long chatId) {
        Chat deletableChat = chatDao.getChatById(chatId);
        if (deletableChat != null)
            chatDao.deleteChat(chatId);
        return "/api/chats";
    }

    public List<Person> getChatMembers(long chatId) {
        List<Person> peopleInChat = new ArrayList<>();
        for (long personId : peopleInChatsDao.getAllPeopleIdInChat(chatId)) {
            peopleInChat.add(personDao.getPersonById(personId));
        }
        return peopleInChat;
    }

    public List<Chat> getChatsByPersonId(long personId) {
        List<Chat> personChats = new ArrayList<>();
        for (long chatId : peopleInChatsDao.getAllChatIdByPersonId(personId)) {
            personChats.add(chatDao.getChatById(chatId));
        }
        return personChats;
    }

    public List<Message> getChatMessages(long chatId) {
        return messageDao.getAllMessagesInChat(chatId);
    }
}
