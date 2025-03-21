package ru.vlsu.ispi.springproject.dto;

import java.util.List;

public class ChatRequestDto {
    private String chatName;
    private List<Long> memberIds;

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public List<Long> getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(List<Long> memberIds) {
        this.memberIds = memberIds;
    }
}
