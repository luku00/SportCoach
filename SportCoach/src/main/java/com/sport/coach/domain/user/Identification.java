package com.sport.coach.domain.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
@Embeddable
public class Identification {

    @Column(name = "USER_LOGIN")
    private String userLogin;

    @Column(name = "USER_PASSWORD")
    private String userPassword;

    public Identification() {
    }

    public Identification(String userLogin, String userPassword) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

}
