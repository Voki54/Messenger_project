package ru.vlsu.ispi.springproject.daos.implementations;


import ru.vlsu.ispi.springproject.models.Message;
import ru.vlsu.ispi.springproject.daos.interfaces.MessageDao;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl implements MessageDao {
    private final DataSource dataSource;

    public MessageDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addMessage(Message message) {
        String query = "INSERT INTO message (id, content, send_time, sender_id, chat_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query)) {
            statement.setLong(1, message.getId());
            statement.setString(2, message.getContent());
            statement.setTimestamp(3, java.sql.Timestamp.valueOf(message.getSendTime()));
            statement.setLong(4, message.getSenderId());
            statement.setLong(5, message.getChatId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error addMessage" + e.getMessage());
        }
    }

    @Override
    public Message getMessageById(long messageId) {
        String query = "SELECT content, send_time, sender_id, chat_id FROM message WHERE id = ?";
        Message message = null;

        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query)) {
            statement.setLong(1, messageId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    message = new Message(
                            messageId,
                            resultSet.getString("content"),
                            resultSet.getTimestamp("send_time").toLocalDateTime(),
                            resultSet.getLong("sender_id"),
                            resultSet.getLong("chat_id")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error getMessageById: " + e.getMessage());
        }
        return message;
    }

    @Override
    public void updateMessage(Message message) {
        String query = "UPDATE message SET content = ?, send_time = ?, sender_id = ?, chat_id = ? WHERE id = ?";

        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query)) {
            statement.setString(1, message.getContent());
            statement.setTimestamp(2, java.sql.Timestamp.valueOf(message.getSendTime()));
            statement.setLong(3, message.getSenderId());
            statement.setLong(4, message.getChatId());
            statement.setLong(5, message.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updateMessage: " + e.getMessage());
        }
    }

    @Override
    public List<Message> getAllMessages() {
        String query = "SELECT * FROM message";
        ArrayList<Message> messages = new ArrayList<>();

        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Message message = new Message(
                        resultSet.getLong("id"),
                        resultSet.getString("content"),
                        resultSet.getTimestamp("send_time").toLocalDateTime(),
                        resultSet.getLong("sender_id"),
                        resultSet.getLong("chat_id")
                );
                messages.add(message);
            }
        } catch (SQLException e) {
            System.out.println("Error getAllMessages: " + e.getMessage());
        }
        return messages;
    }

    @Override
    public List<Message> getAllMessagesInChat(long chatId) {
        String query = "SELECT * FROM message WHERE chat_id = ?";
        ArrayList<Message> messages = new ArrayList<>();

        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query)) {
            statement.setLong(1, chatId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Message message = new Message(
                            resultSet.getLong("id"),
                            resultSet.getString("content"),
                            resultSet.getTimestamp("send_time").toLocalDateTime(),
                            resultSet.getLong("sender_id"),
                            resultSet.getLong("chat_id")
                    );
                    messages.add(message);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error getAllMessagesInChat: " + e.getMessage());
        }
        return messages;
    }

    @Override
    public void deleteMessage(long messageId) {
        String query = "DELETE FROM message WHERE id = ?";

        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query)) {
            statement.setLong(1, messageId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleteMessage: " + e.getMessage());
        }
    }
}
