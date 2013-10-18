package com.sport.coach.domain.user;

import static javax.persistence.EnumType.*;
import static javax.persistence.CascadeType.*;

import com.sport.coach.domain.address.Address;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer userId;

    @Embedded
    private Identification userIdentification;

    @Enumerated(STRING)
    @Column(name = "USER_ROLE")
    private Role role;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    private Address userAddress;

    public User() {
    }

    public User(Integer userId, Identification userIdentification, Role role, Address userAddress) {
        this.userId = userId;
        this.userIdentification = userIdentification;
        this.role = role;
        this.userAddress = userAddress;
    }

    public Integer getUserId() {
        return userId;
    }

    public Identification getUserIdentification() {
        return userIdentification;
    }

    public Role getRole() {
        return role;
    }

    public Address getUserAddress() {
        return userAddress;
    }
}
