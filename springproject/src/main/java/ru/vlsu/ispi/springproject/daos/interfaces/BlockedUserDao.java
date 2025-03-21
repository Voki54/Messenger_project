package ru.vlsu.ispi.springproject.daos.interfaces;

import ru.vlsu.ispi.springproject.models.BlockedUser;

import java.util.List;

public interface BlockedUserDao {
    BlockedUser addBlockedUser(BlockedUser blockedUser);
    void deleteBlockedUser(BlockedUser blockedUser);
    List<Long> getBlockedUserIdsByPersonId(long personId);
}
