package ru.vlsu.ispi.springproject.services;

import org.springframework.ui.Model;
import ru.vlsu.ispi.springproject.daos.interfaces.BlockedUserDao;
import ru.vlsu.ispi.springproject.daos.interfaces.PersonDao;
import ru.vlsu.ispi.springproject.dto.BlacklistPersonDto;
import ru.vlsu.ispi.springproject.models.BlockedUser;
import ru.vlsu.ispi.springproject.models.Person;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private final BlockedUserDao blockedUserDao;
    private final PersonDao personDao;

    public ContactService(BlockedUserDao blockedUserDao, PersonDao personDao) {
        this.blockedUserDao = blockedUserDao;
        this.personDao = personDao;
    }

    public String blockContact(long personId, long blockedUserId) {
        Person person = personDao.getPersonById(personId);
        Person blockedPerson = personDao.getPersonById(blockedUserId);
        if (person != null && blockedPerson != null)
            blockedUserDao.addBlockedUser(new BlockedUser(personId, blockedUserId));
        return "/api/chats";
    }

    public String unblockContact(long personId, long blockedUserId) {
        Person person = personDao.getPersonById(personId);
        Person blockedPerson = personDao.getPersonById(blockedUserId);
        if (person != null && blockedPerson != null)
            blockedUserDao.deleteBlockedUser(new BlockedUser(personId, blockedUserId));
        return "/api/settings/blacklist";
    }

    public List<BlacklistPersonDto> getBlockedUsers(long personId) {
        List<Long> blockedUserIds = blockedUserDao.getBlockedUserIdsByPersonId(personId);
        List<BlacklistPersonDto> blockedUsers = new ArrayList<>();
        for (long userId : blockedUserIds) {
            blockedUsers.add(new BlacklistPersonDto(personDao.getPersonById(userId)));
        }
        return blockedUsers;
    }
}
