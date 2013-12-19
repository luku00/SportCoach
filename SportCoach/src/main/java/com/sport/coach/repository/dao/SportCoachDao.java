package com.sport.coach.repository.dao;

import com.sport.coach.domain.account.Account;
import com.sport.coach.domain.user.User;
import com.sport.jobmanager.common.domain.Job;

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
     */
    void save(Job job);
}
