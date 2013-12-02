package com.sport.coach.domain.view;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserInfo implements Serializable {

    private String login;
    private String firstName;
    private String lastName;
    private Integer accountId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public static class Builder {
        private UserInfo userInfo;

        public Builder() {
            this.userInfo = new UserInfo();
        }

        public UserInfo build() {
            return this.userInfo;
        }

        public Builder withFirstName(String firstName) {
            userInfo.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            userInfo.lastName = lastName;
            return this;
        }

        public Builder withLogin(String login) {
            userInfo.login = login;
            return this;
        }

        public Builder withAccountId(Integer accountId) {
            userInfo.accountId = accountId;
            return this;
        }
    }
}
