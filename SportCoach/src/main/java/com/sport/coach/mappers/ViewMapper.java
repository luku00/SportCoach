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
import com.sport.coach.error.ClientServerException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public class ViewMapper {

    public UserInfo mapUserToUserInfo(User user) {
        return new UserInfo.Builder()
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withLogin(user.getUserIdentification().getUserLogin())
                .withAccountId(user.getAccount().getUserId())
                .build();
    }

    public User mapToUser(UserView userView) {
        return new User.Builder().withFirstName(userView.getFirstName())
                .withLastName(userView.getLastName())
                .withEmail(userView.getEmail())
                .withRole(mapToRole(userView.getUserRole()))
                .withAddress(mapToAddress(userView))
                .withIdentification(mapToIdentification(userView))
                .withBirthDate(mapToJavaDate(userView.getBirthDay(), userView.getBirthMonth(), userView.getBirthYear()))
                .build();
    }

    public Date mapToJavaDate(String day, String month, String year) {
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(day + "/" + month + "/" + year);
        } catch (ParseException e) {

        }
        return date;
    }

    public UserView mapToUserView(User user, UserView userView) throws ClientServerException {
        if (user == null) {
            throw new ClientServerException("Please log in again");
        }
        if (userView == null) {
            userView = new UserView();
        }
        StreetAddress address = (StreetAddress) user.getUserAddress();
        userView.setBirthDay(String.valueOf(user.getUserBirthDate().getDayOfMonth()));
        userView.setBirthMonth(String.valueOf(user.getUserBirthDate().getMonthOfYear()));
        userView.setBirthYear(String.valueOf(user.getUserBirthDate().getYear()));
        userView.setCity(address.getCity());
        userView.setCountry(address.getCountryCode());
        userView.setEmail(user.getEmail());
        userView.setFirstName(user.getFirstName());
        userView.setLastName(user.getLastName());
        userView.setStreetName(address.getStreetName());
        userView.setStreetNumber(address.getStreetNumber());
        userView.setUserRole(user.getRole().name());
        userView.setZip(address.getZipCode());
        userView.setAccountId(user.getAccount().getUserId());
        return userView;
    }

    public DateTime mapToDate(String day, String month, String year) {
        if (day == null || month == null || year == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        return formatter.parseDateTime(day + "/" + month + "/" + year);
    }

    private Identification mapToIdentification(UserView userView) {
        Identification identification = new Identification(userView.getUsername(), userView.getPassword());
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
