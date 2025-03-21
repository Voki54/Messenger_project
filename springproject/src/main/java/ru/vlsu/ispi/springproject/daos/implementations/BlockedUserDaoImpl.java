package ru.vlsu.ispi.springproject.daos.implementations;

import ru.vlsu.ispi.springproject.daos.interfaces.BlockedUserDao;
import ru.vlsu.ispi.springproject.models.BlockedUser;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlockedUserDaoImpl implements BlockedUserDao {
    private final DataSource dataSource;

    public BlockedUserDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public BlockedUser addBlockedUser(BlockedUser blockedUser) {
        String query = "INSERT INTO blockedUser (personId, blockedUserId) VALUES (?, ?)";

        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query)) {
            statement.setLong(1, blockedUser.getPersonId());
            statement.setLong(2, blockedUser.getBlockedUserId());
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating blockedUser failed, no rows affected.");
            }

            return blockedUser;
        } catch (SQLException e) {
            System.out.println("Error addBlockedUser: " + e.getMessage());
        }

        return null;
    }

    @Override
    public void deleteBlockedUser(BlockedUser blockedUser) {
        String query = "DELETE FROM blockedUser WHERE personId = ? AND blockedUserId = ?";
        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query)) {
            statement.setLong(1, blockedUser.getPersonId());
            statement.setLong(2, blockedUser.getBlockedUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleteBlockedUser: " + e.getMessage());
        }
    }

    public List<Long> getBlockedUserIdsByPersonId(long personId) {
        String query = "SELECT blockedUserId FROM chat WHERE personId = ?";
        List<Long> blockedUserIds = new ArrayList<>();
        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query)) {
            statement.setLong(1, personId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    blockedUserIds.add(resultSet.getLong("chat_id"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error getBlockedUserIdsByPersonId: " + e.getMessage());
        }
        return blockedUserIds;
    }
}
