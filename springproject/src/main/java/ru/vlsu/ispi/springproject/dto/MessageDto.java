package ru.vlsu.ispi.springproject.dto;

import ru.vlsu.ispi.springproject.models.Message;

import java.time.LocalDateTime;

public class MessageDto {
    private String content;
    private LocalDateTime sendTime;
    private long senderId;
    private long chatId;

    public MessageDto(String content, LocalDateTime sendTime, long senderId, long chatId) {
        this.content = content;
        this.sendTime = sendTime;
        this.senderId = senderId;
        this.chatId = chatId;
    }

    public MessageDto(Message message) {
        this.content = message.getContent();
        this.sendTime = message.getSendTime();
        this.senderId = message.getSenderId();
        this.chatId = message.getChatId();
    }

    public Message ToMessage() {
        return new Message(
                0L,
                this.content,
                this.sendTime,
                this.senderId,
                this.chatId
        );
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
}
