package ru.vlsu.ispi.springproject.daos.implementations;

import ru.vlsu.ispi.springproject.daos.interfaces.PeopleInChatsDao;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeopleInChatsDaoImpl implements PeopleInChatsDao {
    private DataSource dataSource;

    public PeopleInChatsDaoImpl(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public List<Long> getAllPeopleIdInChat(long chatId) {
        String query = "SELECT person_id FROM person_chat_link WHERE chat_id = ?";
        ArrayList<Long> peopleId = new ArrayList<>();

        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query)) {
            statement.setLong(1, chatId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    peopleId.add(resultSet.getLong("person_id"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error getAllPeopleIdInChat: " + e.getMessage());
        }
        return peopleId;
    }

    @Override
    public List<Long> getAllChatIdByPersonId(long personId) {
        String query = "SELECT chat_id FROM person_chat_link WHERE person_id = ?";
        List<Long> chatId = new ArrayList<>();

        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query)) {
            statement.setLong(1, personId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    chatId.add(resultSet.getLong("chat_id"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error getAllPeopleIdInChat: " + e.getMessage());
        }
        return chatId;
    }

    @Override
    public void addPersonInChat(long personId, long chatId) {
        String query = "INSERT INTO person_chat_link (person_id, chat_id) VALUES (?, ?)";
        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query)) {
            statement.setLong(1, personId);
            statement.setLong(2, chatId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error addPersonInChat: " + e.getMessage());
        }
    }

    @Override
    public void deletePersonFromChat(long personId, long chatId) {
        String query = "DELETE FROM person_chat_link WHERE person_id = ? AND chat_id = ?";
        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query)) {
            statement.setLong(1, personId);
            statement.setLong(2, chatId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deletePersonFromChat: " + e.getMessage());
        }
    }
}
