package com.sport.coach.service.impl;

import com.sport.coach.service.SportCoachSecurityService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Lukas Kubicek
 */
public class SportCoachSecurityServiceImpl implements SportCoachSecurityService {

    private BCryptPasswordEncoder encoder;
    private String defaultPassword;

    @Override
    public String hashPassword(String password) {
        return encoder.encode(password);
    }

    @Override
    public boolean passwordMatch(String password, String hash) {
        return encoder.matches(password, hash);
    }

    public void setEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public void setDefaultPassword(String defaultPassword) {
        this.defaultPassword = defaultPassword;
    }

    @Override
    public String getHashedDefaultPassword() {
        return hashPassword(defaultPassword);
    }

    @Override
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public String getHashedString(String string) {
        String rawHash = encoder.encode(string);
        // this hash might be used as path variable so there can't be some characters
        rawHash.replaceAll("/", "");
        rawHash.replaceAll(".", "");
        return rawHash;
    }
}
