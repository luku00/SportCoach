/**
 * Copyright 2013 TeliaSonera. All rights reserved.
 */
package com.sport.coach.service;

import com.sport.coach.domain.user.User;
import com.sport.coach.error.ClientServerException;

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
}
