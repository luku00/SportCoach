/***************************************************************************************************
 * Copyright 2013 TeliaSonera. All rights reserved.
 **************************************************************************************************/
package com.sport.coach.service.impl;

import com.sport.coach.domain.account.Account;
import com.sport.coach.domain.user.Role;
import com.sport.coach.domain.user.User;
import com.sport.coach.repository.dao.SportCoachDao;
import com.sport.coach.service.SportCoachSecurityService;
import com.sport.coach.service.SportCoachService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public class SportCoachServiceImpl implements SportCoachService {

    private SportCoachDao sportCoachDao;

    private SportCoachSecurityService sportCoachSecurityService;

    @Override
    public User save(User user) {
        User returnedUser = null;
        if (user.getRole() == Role.REQUESTOR) {
            Account account = new Account();
            account.populateNewAccount(user);
            sportCoachDao.save(account);
            returnedUser = user;
        } else if (user.getRole() == Role.BASIC_USER) {
            returnedUser = sportCoachDao.save(user);
        }
        return returnedUser;
    }

    public void setSportCoachDao(SportCoachDao sportCoachDao) {
        this.sportCoachDao = sportCoachDao;
    }

    public void setSportCoachSecurityService(SportCoachSecurityService sportCoachSecurityService) {
        this.sportCoachSecurityService = sportCoachSecurityService;
    }

    @Override
    public boolean checkIfLoginExists(String login) {
        return sportCoachDao.userExist(login);
    }

    @Override
    public User authenticateUser(String login, String password) {
        return sportCoachDao.autehenticateUser(login, password);
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
