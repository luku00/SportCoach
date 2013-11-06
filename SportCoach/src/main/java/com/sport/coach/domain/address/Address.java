package com.sport.coach.domain.address;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
@Entity
@Table(name = "ADDRESSES")
@DiscriminatorColumn(name = "ADDRESS_TYPE")
public abstract class Address {

    @Id
    @Column(name = "ADDRESS_ID")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;

    @Column(name = "CITY")
    private String city;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @Column(name = "COUNTRY_CODE")
    private String countryCode;

    /**
     * Default constructor to be used by JPA only.
     */
    Address() {
        super();
    }

    public Address(String city, String zipCode, String countryCode) {
        super();
        this.city = city;
        this.zipCode = zipCode;
        this.countryCode = countryCode;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Integer getId() {
        return id;
    }

    public boolean isStreetAddress() {
        return false;
    }
}
