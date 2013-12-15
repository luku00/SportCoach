package com.sport.coach.service.impl;

import com.sport.coach.domain.address.StreetAddress;
import com.sport.coach.domain.user.Role;
import com.sport.coach.domain.user.User;
import com.sport.coach.error.ClientServerException;
import com.sport.coach.factory.ObjectFactory;
import com.sport.coach.service.SportCoachService;
import com.sport.coach.test.helpers.CommonAssertions;
import java.text.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author luku00
 */
@ContextConfiguration(locations = {"classpath:spring/service.xml", "classpath:test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SportCoachServiceImplTest {

    @Autowired
    @Qualifier(value = "sportCoachService")
    private SportCoachService service;

    @Test
    public void updateUser() throws ParseException, ClientServerException {
        // create and store account
        User user = ObjectFactory.createSpecificUser(Role.REQUESTOR, "updateUsser");
        service.save(user, null);

        // get user and change data
        user.getUserAddress().updateStreetAddress(new StreetAddress("newStreet", "121", "newCity", "11111", "GB"));
        service.updateUserData(user, user.getUserIdentification().getUserLogin());

        User updatedUser = service.getUser(user.getUserIdentification().getUserLogin());

        // verification
        CommonAssertions.assertEqualUsers(user, updatedUser);
    }
}
