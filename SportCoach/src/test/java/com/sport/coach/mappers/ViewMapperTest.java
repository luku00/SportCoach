/***************************************************************************************************
 * Copyright 2013 TeliaSonera. All rights reserved.
 **************************************************************************************************/
package com.sport.coach.mappers;

import com.sport.coach.domain.address.StreetAddress;
import static org.junit.Assert.*;

import com.sport.coach.domain.user.Role;
import com.sport.coach.domain.user.User;
import com.sport.coach.domain.view.UserView;
import com.sport.coach.factory.ViewDataFactory;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public class ViewMapperTest {

    private ViewMapper viewMapper;

    @Before
    public void setup() {
        viewMapper = new ViewMapper();
    }

    @Test
    public void mapToUser() {
        UserView view = ViewDataFactory.createViewUser(false, Role.REQUESTOR);
        User user = viewMapper.mapToUser(view);

        assertEquals(view.getFirstName(), user.getFirstName());
        assertEquals(view.getLastName(), user.getLastName());
        assertEquals(view.getEmail(), user.getEmail());
        assertEquals(view.getLogin(), user.getUserIdentification().getUserLogin());
        assertEquals(view.getPassword(), user.getUserIdentification().getUserPassword());
        assertEquals(view.getCity(), user.getUserAddress().getCity());
        assertEquals(view.getCountry(), user.getUserAddress().getCountryCode());
        assertEquals(view.getZip(), user.getUserAddress().getZipCode());
        assertTrue(user.getUserAddress().isStreetAddress());
        StreetAddress address = (StreetAddress)user.getUserAddress();
        assertEquals(view.getStreetName(), address.getStreetName());
        assertEquals(view.getStreetNumber(), address.getStreetNumber());
    }

    @Test
    public void mapToUserOnlyRequiredFields() {
        UserView view = ViewDataFactory.createViewUser(true, Role.REQUESTOR);
        User user = viewMapper.mapToUser(view);

        assertEquals(view.getFirstName(), user.getFirstName());
        assertEquals(view.getLastName(), user.getLastName());
        assertEquals(view.getEmail(), user.getEmail());
        assertEquals(view.getLogin(), user.getUserIdentification().getUserLogin());
        assertEquals(view.getPassword(), user.getUserIdentification().getUserPassword());
        assertNull(user.getUserAddress().getCity());
        assertNull(user.getUserAddress().getCountryCode());
        assertNull(user.getUserAddress().getZipCode());
        assertTrue(user.getUserAddress().isStreetAddress());
        StreetAddress address = (StreetAddress)user.getUserAddress();
        assertNull(address.getStreetName());
        assertNull(address.getStreetNumber());
    }

}
