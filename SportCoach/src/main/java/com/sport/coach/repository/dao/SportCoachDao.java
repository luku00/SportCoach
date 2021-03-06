package com.sport.coach.repository.dao;

import com.sport.coach.domain.account.Account;
import com.sport.coach.domain.activity.Activity;
import com.sport.coach.domain.activity.ActivityType;
import com.sport.coach.domain.activity.Plan;
import com.sport.coach.domain.user.User;
import com.sport.jobmanager.common.domain.Job;
import java.util.List;

/**
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public interface SportCoachDao {

    /**
     * Will store user into db
     *
     * @param user
     * @return
     */
    User save(User user);

    /**
     * Will return true if login already exist
     *
     * @param login
     * @return
     */
    boolean userExist(String login);

    /**
     * will check if email exists in db and return User
     *
     * @param email
     * @return
     */
    User getUserByEmail(String email);

    /**
     * Will get user
     *
     * @param login
     * @return
     */
    User getUser(String login);

    /**
     * Will return User if login and password is correct
     *
     * @param login
     * @param password
     * @return
     */
    User autehenticateUser(String login, String password);

    /**
     * will only update user data
     *
     * @param user
     */
    void updateUser(User user);

    public Account save(Account account);

    public Account getAccount(Integer accountId);

    public void updateAccountWithNewUser(User user, Integer accountId);

    /**
     * This will save to db jobManager common object
     * @param job
     */
    void save(Job job);

    /**
     * will get job based on identifier
     *
     * @param jobIdentifier
     * @return
     */
    Job getJobByJobIdentifier(String jobIdentifier);

    /**
     * This will save Plan entity into db
     *
     * @param plan
     */
    void savePlan(Plan plan);

    /**
     * This will save new activity
     *
     * @param activity
     */
    void saveActivity(Activity activity);

    /**
     * This will get all activities based on given userName
     *
     * @param userName
     * @return
     */
    List<Activity> getActivitiesForUser(String userName);

    /**
     * This will return all activity types
     *
     * @return
     */
    List<ActivityType> getActivityTypes();

    /**
     * This will check if imported activity has been already imported
     *
     * @param importId
     * @return
     */
    boolean importActivityExist(String importId);
}
