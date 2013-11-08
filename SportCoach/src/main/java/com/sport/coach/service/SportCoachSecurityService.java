/**
 * Copyright 2013 TeliaSonera. All rights reserved.
 */
package com.sport.coach.service;

/**
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public interface SportCoachSecurityService {

    String hashPassword(String password);

    boolean passwordMatch(String password, String hash);
}
