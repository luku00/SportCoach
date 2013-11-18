package com.sport.coach.service.impl;

import com.sport.coach.service.SportCoachSecurityService;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author luku00
 */
@ContextConfiguration(locations = {"classpath:spring/service.xml", "classpath:test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class SportCoachSecurityServiceImplTest {

    @Autowired
    private SportCoachSecurityService sportCoachSecurityService;

    /**
     * Test of hashPassword method, of class SportCoachSecurityServiceImpl.
     */
    @Test
    public void testHashPassword() {
        String password = "test12*";
        String expResult = "HR4VZV02wLv5NHhXpXGmHZmHm0U=";
        String result = sportCoachSecurityService.hashPassword(password);
        assertEquals(expResult, result);
    }

    /**
     * Test of passwordMatch method, of class SportCoachSecurityServiceImpl.
     */
    @Test
    public void testPasswordMatch() {
        String password = "test12*";
        String hash = "HR4VZV02wLv5NHhXpXGmHZmHm0U=";

        boolean result = sportCoachSecurityService.passwordMatch(password, hash);
        assertTrue(result);

        // not matching
        password = "test12";
        result = sportCoachSecurityService.passwordMatch(password, hash);
        assertFalse(result);
    }

}
