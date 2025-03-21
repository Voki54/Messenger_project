package ru.vlsu.ispi.springproject.dto;

public class NotificationSettingsRequestDto {
    private Long userId;
    private boolean groupNotificationsEnabled;
    private boolean personalNotificationsEnabled;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isPersonalNotificationsEnabled() {
        return personalNotificationsEnabled;
    }

    public void setPersonalNotificationsEnabled(boolean personalNotificationsEnabled) {
        this.personalNotificationsEnabled = personalNotificationsEnabled;
    }

    public boolean isGroupNotificationsEnabled() {
        return groupNotificationsEnabled;
    }

    public void setGroupNotificationsEnabled(boolean groupNotificationsEnabled) {
        this.groupNotificationsEnabled = groupNotificationsEnabled;
    }
}
