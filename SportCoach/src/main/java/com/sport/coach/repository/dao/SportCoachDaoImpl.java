package com.sport.coach.repository.dao;

import com.sport.coach.domain.user.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class SportCoachDaoImpl implements SportCoachDao {

    @Autowired
    private SessionFactory sessionFactory;


    protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

    @Override
    public User save(User user) {
        getCurrentSession().persist(user);
        return user;
    }

    @Override
    public boolean userExist(String login) {
        Query query = getCurrentSession().getNamedQuery("User.findUserByLoging");
        query.setParameter("login", login);
        if (query.list().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public User getUser(String login) {
        Query query = getCurrentSession().getNamedQuery("User.findUserByLoging");
        query.setParameter("login", login);
        List result = query.list();
        if (result.isEmpty() || result.size() > 1) {
            return null;
        }

        return (User)result.iterator().next();
    }

    /**
     * Only for test purposes
     */
    @Deprecated
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User autehenticateUser(String login, String password) {
        Query query = getCurrentSession().getNamedQuery("User.authenticate");
        query.setParameter("login", login);
        query.setParameter("password", password);
        List result = query.list();
        if (result.isEmpty() || result.size() > 1) {
            return null;
        }

        User user = (User)result.iterator().next();
        user.getUserIdentification().secure();;
        return user;
    }

    @Override
    public void updateUser(User user) {
        getCurrentSession().update(user);
    }
}
