package com.sport.coach.service.impl;

import com.sport.coach.domain.account.Account;
import com.sport.coach.domain.user.Role;
import com.sport.coach.domain.user.User;
import com.sport.coach.error.ClientServerException;
import com.sport.coach.repository.dao.SportCoachDao;
import com.sport.coach.service.SportCoachService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public class SportCoachServiceImpl implements SportCoachService {

    private SportCoachDao sportCoachDao;

    @Override
    public User save(User user, Integer accountId) throws ClientServerException {
        if (user.getRole() == Role.REQUESTOR) {
            createRequestorUser(user);
        } else if (user.getRole() == Role.BASIC_USER) {
            createBasicUser(user, accountId);
        }
        return user;
    }

    private void createBasicUser(User user, Integer accountId) throws ClientServerException {
        if (accountId == null) {
            throw new ClientServerException("Login error");
        }
        sportCoachDao.updateAccountWithNewUser(user, accountId);
    }

    private void createRequestorUser(User user) {
        Account account = new Account();
        account.populateNewAccount(user);
        sportCoachDao.save(account);
    }

    public void setSportCoachDao(SportCoachDao sportCoachDao) {
        this.sportCoachDao = sportCoachDao;
    }

    @Override
    public boolean checkIfLoginExists(String login) {
        return sportCoachDao.userExist(login);
    }

    @Override
    public User authenticateUser(String login, String password) {
        User authenticatedUser = sportCoachDao.autehenticateUser(login, password);
        if (authenticatedUser != null) {
            authenticatedUser.getUserIdentification().secure();
        }
        return authenticatedUser;
    }

    @Override
    public User getUser(String login) {
        return sportCoachDao.getUser(login);
    }

    @Override
    @Transactional
    public User updateUserData(User user, String login) {
        User storedUser = sportCoachDao.getUser(login);
        storedUser.setNewUserData(user);
        return storedUser;
    }
}
