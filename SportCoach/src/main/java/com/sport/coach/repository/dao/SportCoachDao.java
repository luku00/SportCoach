package com.sport.coach.repository.dao;

import com.sport.coach.domain.user.User;

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
}
