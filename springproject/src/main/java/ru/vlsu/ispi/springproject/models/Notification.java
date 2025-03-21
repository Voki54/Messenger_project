package ru.vlsu.ispi.springproject.models;

public class Notification {

    public Notification(Long userId){
        this.userId = userId;
    }

    private Long userId;
    private boolean groupNotificationsEnabled = true;
    private boolean personalNotificationsEnabled = true;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isGroupNotificationsEnabled() {
        return groupNotificationsEnabled;
    }

    public void setGroupNotificationsEnabled(boolean groupNotificationsEnabled) {
        this.groupNotificationsEnabled = groupNotificationsEnabled;
    }

    public boolean isPersonalNotificationsEnabled() {
        return personalNotificationsEnabled;
    }

    public void setPersonalNotificationsEnabled(boolean personalNotificationsEnabled) {
        this.personalNotificationsEnabled = personalNotificationsEnabled;
    }
}
