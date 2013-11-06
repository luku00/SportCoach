/***************************************************************************************************
 * Copyright 2013 TeliaSonera. All rights reserved.
 **************************************************************************************************/
package com.sport.coach.domain.address;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
@Entity
public class StreetAddress extends Address {

    @Column(name = "STREET_NAME")
    private String streetName;

    @Column(name = "STREET_NUMBER")
    private String streetNumber;

    /**
     * Default constructor to be used by JPA only.
     */
    StreetAddress() {
        super();
    }

    public StreetAddress(String streetName, String streetNumber, String city, String zipCode, String countryCode) {
        super(city, zipCode, countryCode);
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    @Override
    public boolean isStreetAddress() {
        return true;
    }
}
