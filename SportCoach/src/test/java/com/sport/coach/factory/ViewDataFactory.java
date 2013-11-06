/***************************************************************************************************
 * Copyright 2013 TeliaSonera. All rights reserved.
 **************************************************************************************************/
package com.sport.coach.factory;

import com.sport.coach.domain.user.Role;
import com.sport.coach.domain.view.UserView;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public class ViewDataFactory {

    public static UserView createViewUser(boolean skipNotRequiredFields, Role role) {
        UserView userView = new UserView();
        userView.setFirstName("Lukas");
        userView.setLastName("Kubicek");
        userView.setEmail("test@test.com");
        userView.setLogin("luku");
        userView.setPassword("dgsfds");
        userView.setUserRole(role.name());
        if (!skipNotRequiredFields) {
            userView.setStreetName("Ostravska");
            userView.setCity("Ostrava");
            userView.setCountry("CZ");
            userView.setStreetNumber("10");
            userView.setZip("70020");
        }
        return userView;
    }
}
