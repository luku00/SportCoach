package com.sport.coach.factory;

import com.sport.coach.domain.address.Address;
import com.sport.coach.domain.address.StreetAddress;
import com.sport.coach.domain.user.Identification;
import com.sport.coach.domain.user.Role;
import com.sport.coach.domain.user.User;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public class ObjectFactory {

    public static final String FIRST_NAME = "Lukas";
    public static final String LAST_NAME = "Kubicek";
    public static final String ADDRESS_STREET = "Ostravska";
    public static final String ADDRESS_STREET_NUMBER = "911";
    public static final String ADDRESS_CITY = "Ostrava";
    public static final String ADDRESS_ZIP = "70020";
    public static final String ADDRESS_COUNTRY = "CZ";
    public static final String USER_LOGIN = "dehe00";
    public static final String USER_PASSWORD = "dehe00";
    public static final String USER_EMAIL = "dehe00@test.com";

    public static User createNewUser(Role role) {
        return createSpecificUser(role, USER_LOGIN);
    }

    public static User createSpecificUser(Role role, String login) {
        return new User.Builder().withFirstName(FIRST_NAME)
                .withLastName(LAST_NAME)
                .withRole(role)
                .withAddress(createAddress())
                .withIdentification(createUserIdentification(login, USER_PASSWORD))
                .withEmail(USER_EMAIL)
                .build();
    }

    public static Address createAddress() {
        return new StreetAddress(ADDRESS_STREET, ADDRESS_STREET_NUMBER, ADDRESS_CITY, ADDRESS_ZIP, ADDRESS_COUNTRY);
    }

    public static Identification createUserIdentification(String login, String password) {
        return new Identification(login, password);
    }
}
