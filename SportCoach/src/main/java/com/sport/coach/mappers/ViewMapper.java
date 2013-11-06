/***************************************************************************************************
 * Copyright 2013 TeliaSonera. All rights reserved.
 **************************************************************************************************/
package com.sport.coach.mappers;

import com.sport.coach.domain.address.Address;
import com.sport.coach.domain.address.StreetAddress;
import com.sport.coach.domain.user.Identification;
import com.sport.coach.domain.user.Role;
import com.sport.coach.domain.user.User;
import com.sport.coach.domain.view.UserView;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public class ViewMapper {

    public User mapToUser(UserView userView) {
        return new User.Builder().withFirstName(userView.getFirstName())
                .withLastName(userView.getLastName())
                .withEmail(userView.getEmail())
                .withRole(mapToRole(userView.getUserRole()))
                .withAddress(mapToAddress(userView))
                .withIdentification(mapToIdentification(userView))
                .build();
    }

    private Identification mapToIdentification(UserView userView) {
        Identification identification = new Identification(userView.getLogin(), userView.getPassword());
        return identification;
    }

    private Address mapToAddress(UserView userView) {
        Address address = new StreetAddress(userView.getStreetName(), userView.getStreetNumber(),
                userView.getCity(), userView.getZip(), userView.getCountry());
        return address;
    }

    private Role mapToRole(String sRole) {
        if (sRole == null) {
            return null;
        }
        return Role.valueOf(sRole);
    }
}
