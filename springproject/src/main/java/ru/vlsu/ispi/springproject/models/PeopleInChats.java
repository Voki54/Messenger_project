package ru.vlsu.ispi.springproject.models;

public class PeopleInChats {
    private long personId;
    private long chatId;

    public PeopleInChats(long personId, long chatId){
        this.personId = personId;
        this.chatId = chatId;
    }

    public long getChatId() {
        return chatId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }
}
