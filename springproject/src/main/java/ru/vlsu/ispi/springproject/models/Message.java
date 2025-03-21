package ru.vlsu.ispi.springproject.models;

import java.time.LocalDateTime;

public class Message {
    private long id;
    private String content;
    private LocalDateTime sendTime;
    private long senderId;
    private long chatId;

    public Message(long id, String content, LocalDateTime sendTime, long senderId, long chatId) {
        this.id = id;
        this.content = content;
        this.sendTime = sendTime;
        this.senderId = senderId;
        this.chatId = chatId;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public long getSenderId() {
        return senderId;
    }

    public long getChatId() {
        return chatId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDateTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }
}