package com.sport.coach.service;

/**
 * @author Lukas Kubicek
 */
public interface SportCoachSecurityService {

    /**
     * will hash given password based on set encoder
     */
    String hashPassword(String password);

    /**
     * give true if passwords match
     */
    boolean passwordMatch(String password, String hash);

    /**
     * will read default password from configuration and return it as hashed
     * password
     */
    String getHashedDefaultPassword();
}
