/**
 * Copyright 2013 TeliaSonera. All rights reserved.
 */
package com.sport.coach.service;

import com.sport.coach.domain.user.User;

/**
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public interface SportCoachService {

    User save(User user);

    boolean checkIfLoginExists(String login);

    User authenticateUser(String login, String password);

    User getUser(String login);

    User updateUserData(User user, String login);
}
