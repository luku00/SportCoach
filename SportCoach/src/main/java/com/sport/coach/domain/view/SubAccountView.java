package com.sport.coach.domain.view;

/**
 *
 * @author luku00
 */
public class SubAccountView {

    private String firstName;
    private String lastName;
    private String email;
    private String username;

    public SubAccountView(String firstName, String lastName, String email, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
}
