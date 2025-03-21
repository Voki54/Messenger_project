package ru.vlsu.ispi.springproject.daos.implementations;


import ru.vlsu.ispi.springproject.daos.interfaces.NotificationDao;
import ru.vlsu.ispi.springproject.models.Notification;

import javax.sql.DataSource;

public class NotificationDaoImpl implements NotificationDao {
    private final DataSource dataSource;

    public NotificationDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addNotification(Notification notification){
        //Добавление notification в БД
    }

    @Override
    public Notification getNotificationByUserId(long userId) {
        //Получение notification из БД
        return new Notification(userId);
    }

    @Override
    public Notification updateNotification(Notification notification){
        //Обновление notification в БД
        return notification;
    }
}
