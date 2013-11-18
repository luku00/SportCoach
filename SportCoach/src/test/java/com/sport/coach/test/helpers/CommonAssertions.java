package com.sport.coach.test.helpers;

import com.sport.coach.domain.address.Address;
import com.sport.coach.domain.address.StreetAddress;
import com.sport.coach.domain.user.User;
import static org.junit.Assert.*;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public class CommonAssertions {

    /**
     * Will assert two users for equivalency
     *
     * @param requested requested user
     * @param result resulted user
     */
    public static boolean assertEqualUsers(User requested, User result) {
        boolean eq = true;
        if (requested != null && result != null) {
            // assert names and email
            assertEquals(requested.getFirstName(), result.getFirstName());
            assertEquals(requested.getLastName(), result.getLastName());
            assertEquals(requested.getEmail(), result.getEmail());
            if (requested.getUserAddress() != null) {
                assertTrue(assertEqualStreetAddresses(requested.getUserAddress(), result.getUserAddress()));
            }
            assertEquals(requested.getRole(), result.getRole());
        } else if (requested == null && result != null) {
            eq = false;
        } else if (requested != null && result == null) {
            eq = false;
        }
        return eq;
    }

    public static boolean assertEqualStreetAddresses(Address requested, Address result) {
        boolean eq = true;
        if (requested != null && result != null) {
            // assert equivalency
            assertEquals(requested.isStreetAddress(), result.isStreetAddress());
            assertEquals(requested.getCity(), result.getCity());
            assertEquals(requested.getZipCode(), result.getZipCode());
            assertEquals(requested.getCountryCode(), result.getCountryCode());
            StreetAddress streetRequested = (StreetAddress)requested;
            StreetAddress streetResult = (StreetAddress)result;
            assertEquals(streetRequested.getStreetName(), streetResult.getStreetName());
            assertEquals(streetRequested.getStreetNumber(), streetResult.getStreetNumber());
        } else if (requested == null && result != null) {
            eq = false;
        } else if (requested != null && result == null) {
            eq = false;
        }
        return eq;
    }
}
