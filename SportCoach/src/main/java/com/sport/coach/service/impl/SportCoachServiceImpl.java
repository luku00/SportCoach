/***************************************************************************************************
 * Copyright 2013 TeliaSonera. All rights reserved.
 **************************************************************************************************/
package com.sport.coach.service.impl;

import com.sport.coach.domain.user.User;
import com.sport.coach.repository.dao.SportCoachDao;
import com.sport.coach.service.SportCoachSecurityService;
import com.sport.coach.service.SportCoachService;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public class SportCoachServiceImpl implements SportCoachService {

    private SportCoachDao sportCoachDao;

    private SportCoachSecurityService sportCoachSecurityService;

    @Override
    public User save(User user) {
        return sportCoachDao.save(user);
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
    public User authenticateUser(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
