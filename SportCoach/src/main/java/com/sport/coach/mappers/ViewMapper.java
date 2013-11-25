/***************************************************************************************************
 * Copyright 2013 TeliaSonera. All rights reserved.
 **************************************************************************************************/
package com.sport.coach.mappers;

import com.sport.coach.domain.address.Address;
import com.sport.coach.domain.address.StreetAddress;
import com.sport.coach.domain.user.Identification;
import com.sport.coach.domain.user.Role;
import com.sport.coach.domain.user.User;
import com.sport.coach.domain.view.UserInfo;
import com.sport.coach.domain.view.UserView;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public class ViewMapper {

    public UserInfo mapUserToUserInfo(User user, boolean isLogged) {
        return new UserInfo.Builder()
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withLogin(user.getUserIdentification().getUserLogin())
                .withIsLogged(isLogged)
                .build();
    }

    public User mapToUser(UserView userView) {
        return new User.Builder().withFirstName(userView.getFirstName())
                .withLastName(userView.getLastName())
                .withEmail(userView.getEmail())
                .withRole(mapToRole(userView.getUserRole()))
                .withAddress(mapToAddress(userView))
                .withIdentification(mapToIdentification(userView))
                .withBirthDate(mapToDate(userView.getBirthDay(), userView.getBirthMonth(), userView.getBirthYear()))
                .build();
    }

    public DateTime mapToDate(String day, String month, String year) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        return formatter.parseDateTime(day + "/" + month + "/" + year);
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
