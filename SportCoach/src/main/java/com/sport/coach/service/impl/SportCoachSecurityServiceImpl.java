/***************************************************************************************************
 * Copyright 2013 TeliaSonera. All rights reserved.
 **************************************************************************************************/
package com.sport.coach.service.impl;

import com.sport.coach.service.SportCoachSecurityService;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public class SportCoachSecurityServiceImpl implements SportCoachSecurityService {

    MessageDigest md = null;

    public String hashPassword(String password) {
        try {
            md = MessageDigest.getInstance("SHA"); //step 2
        } catch (NoSuchAlgorithmException e) {
        }
        try {
            md.update(password.getBytes("UTF-8")); //step 3
        } catch (UnsupportedEncodingException e) {
        }
        byte raw[] = md.digest(); //step 4
        String hash = (new BASE64Encoder()).encode(raw); //step 5
        return hash; //step 6

    }

    public boolean passwordMatch(String password, String hash) {
        String newHash = hashPassword(password);
        if (newHash.equals(hash)) {
            return true;
        } else {
            return false;
        }
    }
}
