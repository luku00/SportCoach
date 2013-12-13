/***************************************************************************************************
 * Copyright 2013 TeliaSonera. All rights reserved.
 **************************************************************************************************/
package com.sport.coach.service.impl;

import com.sport.coach.service.SportCoachSecurityService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public class SportCoachSecurityServiceImpl implements SportCoachSecurityService {

    private BCryptPasswordEncoder encoder;

    @Override
    public String hashPassword(String password) {
        return encoder.encode(password);
    }

    public boolean passwordMatch(String password, String hash) {
        return encoder.matches(password, hash);
    }

    public void setEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

}
