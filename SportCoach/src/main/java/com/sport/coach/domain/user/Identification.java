package com.sport.coach.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
@Entity
@Table(name = "USERS_IDENTIFICATION")
public class Identification {

    @Id
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

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void secure() {
        this.userPassword = null;
    }
}
