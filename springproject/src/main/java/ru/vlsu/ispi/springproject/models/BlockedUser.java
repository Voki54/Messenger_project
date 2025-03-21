package ru.vlsu.ispi.springproject.models;

public class BlockedUser {
    private long personId;
    private long blockedUserId;

    public BlockedUser(long personId, long blockedUserId){
     this.personId = personId;
     this.blockedUserId = blockedUserId;
    }

    public long getPersonId() {
        return personId;
    }

    public long getBlockedUserId() {
        return blockedUserId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public void setBlockedUserId(long blockedUserId) {
        this.blockedUserId = blockedUserId;
    }
}
