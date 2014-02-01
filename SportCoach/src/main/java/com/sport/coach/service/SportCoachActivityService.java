package com.sport.coach.service;

import com.sport.coach.domain.activity.Activity;
import com.sport.coach.domain.activity.ActivityType;
import java.util.List;

/**
 *
 * @author luku00
 */
public interface SportCoachActivityService {

    /**
     * This will load all activities for specific user
     *
     * @param userName
     * @return
     */
    public List<Activity> getAllActivitiesForUser(String userName);

    /**
     * Will fetch all activity types from db
     *
     * @return
     */
    public List<ActivityType> getAllActivityTypes();
}
