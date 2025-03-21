package ru.vlsu.ispi.springproject.daos.interfaces;

import ru.vlsu.ispi.springproject.models.Notification;

import java.util.List;

public interface NotificationDao {
    void addNotification(Notification notification);
    Notification getNotificationByUserId(long id);
    Notification updateNotification(Notification notification);
}