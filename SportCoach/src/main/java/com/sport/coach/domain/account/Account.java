package com.sport.coach.domain.account;

import com.sport.coach.domain.user.User;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
@NamedQueries({
    @NamedQuery(name = "Account.findAccountById", query = "select a from Account a where userId = :id")
})
@Entity
@Table(name = "ACCOUNTS")
public class Account {

    public static final String ACCOUNT_PREFIX = "acc";

    @Id
    @Column(name = "ACCOUNT_ID")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer userId;

    @Column(name = "ACCOUNT_NAME")
    private String accountName;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<User> users;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Set<User> getUsers() {
        if (users == null) {
            users = new HashSet<User>();
        }
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * This will create new account and set all needed fields Use only for new
     * Account
     *
     * @param user
     */
    public void populateNewAccount(User user) {
        getUsers().add(user);
        populateAccountToAllUsers();
        accountName = ACCOUNT_PREFIX + "-" + user.getUserIdentification().getUserLogin();
    }

    public void populateAccountToAllUsers() {
        for (User usr : users) {
            usr.setAccount(this);
        }
    }

    public User getRequestor() {
        User requestor = null;
        if (users != null || !users.isEmpty()) {
            for (User user : users) {
                if (user.isRequestor()) {
                    requestor = user;
                    break;
                }
            }
        }
        return requestor;
    }
}
