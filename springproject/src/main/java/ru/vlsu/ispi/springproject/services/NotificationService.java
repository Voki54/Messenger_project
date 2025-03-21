package ru.vlsu.ispi.springproject.services;

import ru.vlsu.ispi.springproject.daos.interfaces.NotificationDao;
import ru.vlsu.ispi.springproject.daos.interfaces.PersonDao;
import ru.vlsu.ispi.springproject.dto.NotificationSettingsRequestDto;
import ru.vlsu.ispi.springproject.models.Notification;

public class NotificationService {

    private final NotificationDao notificationDao;

    public NotificationService(NotificationDao notificationDao){
        this.notificationDao = notificationDao;
    }

    public String updateNotifications(NotificationSettingsRequestDto request) {
        Notification notification = notificationDao.getNotificationByUserId(request.getUserId());
        notification.setGroupNotificationsEnabled(request.isGroupNotificationsEnabled());
        notification.setPersonalNotificationsEnabled(request.isPersonalNotificationsEnabled());
        notificationDao.updateNotification(notification);
        return "/api/account/settings/notifications";
    }

    public String resetNotifications() {
        //Получение Id текущего пользователя
        long userId = 1L; //Заглушка
        Notification notification = notificationDao.getNotificationByUserId(userId);
        notification.setGroupNotificationsEnabled(false);
        notification.setPersonalNotificationsEnabled(false);
        notificationDao.updateNotification(notification);
        return "/api/account/settings/notifications";
    }

}
