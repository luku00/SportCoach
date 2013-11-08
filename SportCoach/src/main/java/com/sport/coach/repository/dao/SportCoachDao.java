package com.sport.coach.repository.dao;

import com.sport.coach.domain.user.User;

/**
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public interface SportCoachDao {

    User save(User user);

    boolean userExist(String login);

    User getUser(String login);
}
