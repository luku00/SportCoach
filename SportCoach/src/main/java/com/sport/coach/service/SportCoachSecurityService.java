package com.sport.coach.service;

/**
 * @author Lukas Kubicek
 */
public interface SportCoachSecurityService {

    /**
     * will hash given password based on set encoder
     * @param password
     * @return
     */
    String hashPassword(String password);

    /**
     * give true if passwords match
     * @param password
     * @param hash
     * @return
     */
    boolean passwordMatch(String password, String hash);

    /**
     * will read default password from configuration and return it as hashed
     * password
     * @return
     */
    String getHashedDefaultPassword();

    /**
     * Will hash any string
     *
     * @param string
     * @return
     */
    String getHashedString(String string);
}
