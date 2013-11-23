package com.sport.coach.domain.view;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public class UserInfo {

    private String login;
    private String firstName;
    private String lastName;

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
    }
}
