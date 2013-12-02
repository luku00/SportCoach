package com.sport.coach.domain.user;

import com.sport.coach.domain.account.Account;
import static javax.persistence.EnumType.*;
import static javax.persistence.CascadeType.*;

import com.sport.coach.domain.address.Address;
import com.sport.coach.domain.address.StreetAddress;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Temporal;
import org.joda.time.DateTime;


/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
@NamedQueries({
    @NamedQuery(name = "User.findUserByLoging", query = "select u from User u where userIdentification.userLogin = :login"),
    @NamedQuery(name = "User.authenticate", query = "select u from User u where userIdentification.userLogin = :login and userIdentification.userPassword = :password"),
})
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer userId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne(fetch = FetchType.EAGER, cascade = ALL)
    @JoinColumn(name="USER_LOGIN")
    private Identification userIdentification;

    @Enumerated(STRING)
    @Column(name = "USER_ROLE")
    private Role role;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    private Address userAddress;

    @Column(name="BIRTH_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    public User() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Only for JPA purposes
     */
    @Deprecated
    public Date getBirthDate() {
        return birthDate;
    }

    public DateTime getUserBirthDate() {
        return new DateTime(birthDate);
    }

    public void setNewUserData(User updatedUser) {
        this.firstName = updatedUser.getFirstName();
        this.lastName = updatedUser.getLastName();
        this.email = updatedUser.getEmail();
        this.userAddress.updateStreetAddress((StreetAddress) updatedUser.getUserAddress());
    }

    public static class Builder {
        private User user;

        public Builder() {
            this.user = new User();
        }

        public User build() {
            return user;
        }

        public Builder withFirstName(String firstName) {
            user.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            user.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email) {
            user.email = email;
            return this;
        }

        public Builder withIdentification(Identification identification) {
            user.userIdentification = identification;
            return this;
        }

        public Builder withAddress(Address address) {
            user.userAddress = address;
            return this;
        }

        public Builder withRole(Role role) {
            user.role = role;
            return this;
        }

        public Builder withBirthDate(Date BirthDate) {
            user.birthDate = BirthDate;
            return this;
        }
    }
}
