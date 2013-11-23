package com.sport.coach.repository;

import com.sport.coach.domain.user.Role;
import com.sport.coach.domain.user.User;
import com.sport.coach.factory.ObjectFactory;
import com.sport.coach.repository.dao.SportCoachDao;
import com.sport.coach.test.helpers.CommonAssertions;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
@ContextConfiguration(locations = {"classpath:spring/service.xml", "classpath:test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class RepositoryTest {

    @Autowired
    private SportCoachDao dao;

    @Before
    public void setUp() {

    }

    @Test
    public void initTest() {
        assertNotNull(dao);
    }

    @Test
    public void storeAndGetUser() {
        User user = ObjectFactory.createNewUser(Role.REQUESTOR);
        User storedUser = dao.save(user);
        CommonAssertions.assertEqualUsers(user, storedUser);

        // get stored user
        User persistedUser = dao.getUser(storedUser.getUserIdentification().getUserLogin());
        CommonAssertions.assertEqualUsers(storedUser, persistedUser);
    }

    @Test
    public void userExist() {
        User user = dao.save(ObjectFactory.createSpecificUser(Role.REQUESTOR, "loto"));
        assertTrue(dao.userExist(user.getUserIdentification().getUserLogin()));
        assertFalse(dao.userExist("newLogin"));
    }

    @Test
    public void authenticateUser() {
        String login = "losos";
        User user = dao.save(ObjectFactory.createSpecificUser(Role.REQUESTOR, login));
        User authenticatedUser = dao.autehenticateUser(login, user.getUserIdentification().getUserPassword());

        // assertions
        assertEquals(user.getEmail(), authenticatedUser.getEmail());
        assertEquals(user.getFirstName(), authenticatedUser.getFirstName());
        assertEquals(user.getLastName(), authenticatedUser.getLastName());
        assertNull(authenticatedUser.getUserIdentification().getUserPassword());
    }
}
