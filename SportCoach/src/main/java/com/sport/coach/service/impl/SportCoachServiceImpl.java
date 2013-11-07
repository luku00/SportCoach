/***************************************************************************************************
 * Copyright 2013 TeliaSonera. All rights reserved.
 **************************************************************************************************/
package com.sport.coach.service.impl;

import com.sport.coach.domain.user.User;
import com.sport.coach.repository.dao.SportCoachDao;
import com.sport.coach.service.SportCoachService;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public class SportCoachServiceImpl implements SportCoachService {

    private SportCoachDao sportCoachDao;

    @Override
    public User save(User user) {
        return sportCoachDao.save(user);
    }

    public void setSportCoachDao(SportCoachDao sportCoachDao) {
        this.sportCoachDao = sportCoachDao;
    }

}
