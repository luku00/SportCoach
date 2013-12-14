package com.sport.coach.repository;

import com.sport.coach.domain.account.Account;
import com.sport.coach.domain.user.Role;
import com.sport.coach.domain.user.User;
import com.sport.coach.factory.ObjectFactory;
import com.sport.coach.repository.dao.SportCoachDao;
import com.sport.coach.test.helpers.CommonAssertions;
import java.text.ParseException;
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
@ContextConfiguration(locations = {"classpath:spring/service.xml", "classpath:test.xml"})
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
    public void storeAndGetRequestorUser() throws ParseException {
        User user = ObjectFactory.createNewUser(Role.REQUESTOR);
        Account acc = new Account();
        acc.populateNewAccount(user);
        Account accs = dao.save(acc);

        assertNotNull(accs);
        assertNotNull(accs.getUsers());
        User storedUser = accs.getUsers().iterator().next();
        assertNotNull(storedUser);
        CommonAssertions.assertEqualUsers(user, storedUser);
    }

    @Test
    public void storeAndGetUsers() throws ParseException {
        User user = ObjectFactory.createSpecificUser(Role.BASIC_USER, "luku");
        User requestor = ObjectFactory.createSpecificUser(Role.REQUESTOR, "lukus");
        Account acc = new Account();
        acc.populateNewAccount(requestor);

        // save account with requestor
        Account accs = dao.save(acc);

        // update account with new user
        dao.updateAccountWithNewUser(user, accs.getUserId());

        // get stored account
        accs = dao.getAccount(accs.getUserId());

        // assertions
        assertNotNull(accs);
        assertEquals(2, accs.getUsers().size());

        CommonAssertions.assertEqualUsers(requestor, accs.getRequestor());

        // get stored user
        User persistedUser = dao.getUser(user.getUserIdentification().getUserLogin());
        CommonAssertions.assertEqualUsers(user, persistedUser);
        assertNotNull(persistedUser.getAccount());
    }

    @Test
    public void userExist() throws ParseException {
        User user = dao.save(ObjectFactory.createSpecificUser(Role.REQUESTOR, "loto"));
        assertTrue(dao.userExist(user.getUserIdentification().getUserLogin()));
        assertFalse(dao.userExist("newLogin"));
    }

    @Test
    public void authenticateUser() throws ParseException {
        String login = "losos";
        User user = dao.save(ObjectFactory.createSpecificUser(Role.REQUESTOR, login));
        User authenticatedUser = dao.autehenticateUser(login, user.getUserIdentification().getUserPassword());

        // assertions
        assertEquals(user.getEmail(), authenticatedUser.getEmail());
        assertEquals(user.getFirstName(), authenticatedUser.getFirstName());
        assertEquals(user.getLastName(), authenticatedUser.getLastName());
    }
}
