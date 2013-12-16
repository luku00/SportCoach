/***************************************************************************************************
 * Copyright 2013 TeliaSonera. All rights reserved.
 **************************************************************************************************/
package com.sport.coach.domain.view;

import java.io.Serializable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserView implements Serializable {

    private Integer accountId;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String userRole;
    private String city;
    private String zip;
    private String country;
    private String streetName;
    private String streetNumber;
    private String birthDay;
    private String birthMonth;
    private String birthYear;

    private UserView subUserView;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirtDateAsString() {
        return birthDay + "-" + birthMonth + "-" + birthYear;
    }

    public UserView getSubUserView() {
        return subUserView;
    }

    public void setSubUserView(UserView subUserView) {
        this.subUserView = subUserView;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public static class Builder {

        private UserView userView;

        public Builder() {
            this.userView = new UserView();
        }

        public UserView build() {
            return this.userView;
        }

        public Builder withFirstName(String firstName) {
            userView.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            userView.lastName = lastName;
            return this;
        }

        public Builder withUsername(String username) {
            userView.username = username;
            return this;
        }

        public Builder withEmail(String email) {
            userView.email = email;
            return this;
        }

        public Builder withUserRole(String userRole) {
            userView.userRole = userRole;
            return this;
        }

        public Builder withCity(String city) {
            userView.city = city;
            return this;
        }

        public Builder withZip(String zip) {
            userView.zip = zip;
            return this;
        }

        public Builder withCountry(String country) {
            userView.country = country;
            return this;
        }

        public Builder withStreetNumber(String streetNumber) {
            userView.streetNumber = streetNumber;
            return this;
        }

        public Builder withStreetName(String streetName) {
            userView.streetName = streetName;
            return this;
        }

        public Builder withBirthDay(String birthDay) {
            userView.birthDay = birthDay;
            return this;
        }

        public Builder withBirthMonth(String birthMonth) {
            userView.birthMonth = birthMonth;
            return this;
        }

        public Builder withBirthYear(String birthYear) {
            userView.birthYear = birthYear;
            return this;
        }

        public Builder withAccountId(Integer accountId) {
            userView.accountId = accountId;
            return this;
        }
    }

}
