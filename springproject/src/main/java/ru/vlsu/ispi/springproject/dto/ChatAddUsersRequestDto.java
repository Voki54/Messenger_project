package ru.vlsu.ispi.springproject.dto;

import java.util.List;

public class ChatAddUsersRequestDto {
    private List<Long> usersIds;

    public List<Long> getUsersIds() {
        return usersIds;
    }

    public void setUsersIds(List<Long> usersIds) {
        this.usersIds = usersIds;
    }
}
