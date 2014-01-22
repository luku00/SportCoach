package com.sport.coach.service;

import com.sport.coach.domain.user.User;
import com.sport.coach.error.ClientServerException;
import java.util.Date;

/**
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public interface SportCoachService {

    User save(User user, Integer accountId) throws ClientServerException;

    boolean checkIfLoginExists(String login);

    User authenticateUser(String login, String password);

    User getUser(String login);

    User updateUserData(User user, String login);

    /**
     * This will decide if user using login or email and will authenticate. Then
     * will create job for sending email
     *
     * @param loginOrEmial
     * @return
     */
    boolean passwordReset(String loginOrEmial);

    /**
     * This will change password based on job identifier
     *
     * @param newPassword
     * @param jobIdentifier
     */
    void passwordChange(String newPassword, String jobIdentifier);

    /**
     * This will get user email from hashed param
     *
     * @param jobIdentifier
     * @return
     */
    String getUserEmail(String jobIdentifier);

    /**
     * Method should create new plan for specific user
     *
     * @param fromDate plan start date
     * @param toDate plat finish date
     * @param goal goal of the plan
     * @param goalType type of the goal
     * @param userName user name
     */
    void createNewPlan(Date fromDate, Date toDate, String goal, String goalType, String userName, String reward);
}
