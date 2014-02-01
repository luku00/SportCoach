package com.sport.coach.service.impl;

import com.sport.coach.domain.activity.Activity;
import com.sport.coach.domain.activity.ActivityType;
import com.sport.coach.repository.dao.SportCoachDao;
import com.sport.coach.service.SportCoachActivityService;
import java.util.List;

/**
 *
 * @author luku00
 */
public class SportCoachActivityServiceImpl implements SportCoachActivityService {

    private SportCoachDao sportCoachDao;

    @Override
    public List<Activity> getAllActivitiesForUser(String userName) {
        return sportCoachDao.getActivitiesForUser(userName);
    }

    public void setSportCoachDao(SportCoachDao sportCoachDao) {
        this.sportCoachDao = sportCoachDao;
    }

    @Override
    public List<ActivityType> getAllActivityTypes() {
        return sportCoachDao.getActivityTypes();
    }

}
