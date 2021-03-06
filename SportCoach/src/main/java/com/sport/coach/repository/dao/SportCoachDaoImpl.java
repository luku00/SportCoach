package com.sport.coach.repository.dao;

import com.sport.coach.domain.account.Account;
import com.sport.coach.domain.activity.Activity;
import com.sport.coach.domain.activity.ActivityType;
import com.sport.coach.domain.activity.Plan;
import com.sport.coach.domain.user.User;
import com.sport.jobmanager.common.domain.Job;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lukas Kubicek
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
    public Account save(Account account) {
        getCurrentSession().persist(account);
        return account;
    }

    @Override
    public void save(Job job) {
        getCurrentSession().persist(job);
    }

    @Override
    public boolean userExist(String login) {
        Query query = getCurrentSession().getNamedQuery("User.findUserByLoging");
        query.setParameter("login", login);

        return !query.list().isEmpty();
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
        return user;
    }

    @Override
    public void updateUser(User user) {
        getCurrentSession().update(user);
    }

    @Override
    public Account getAccount(Integer accountId) {
        Query query = getCurrentSession().getNamedQuery("Account.findAccountById");
        query.setParameter("id", accountId);
        List result = query.list();
        if (result.isEmpty() || result.size() > 1) {
            return null;
        }
        Account account = (Account) result.iterator().next();
        return account;
    }

    @Override
    public void updateAccountWithNewUser(User user, Integer accountId) {
        Account account = getAccount(accountId);
        user.setAccount(account);
        account.getUsers().add(user);
    }

    @Override
    public User getUserByEmail(String email) {
        Query query = getCurrentSession().getNamedQuery("User.findUserByEmail");
        query.setParameter("email", email);
        List result = query.list();
        if (result.isEmpty() || result.size() > 1) {
            return null;
        }
        return (User) result.iterator().next();
    }

    @Override
    public Job getJobByJobIdentifier(String jobIdentifier) {
        Query query = getCurrentSession().getNamedQuery("Job.findJobByIdentifier");
        query.setParameter("jobIdentifier", jobIdentifier);
        List result = query.list();
        if (result.isEmpty() || result.size() > 1) {
            return null;
        }
        return (Job) result.iterator().next();
    }

    @Override
    public void savePlan(Plan plan) {
        getCurrentSession().save(plan);
    }

    @Override
    public void saveActivity(Activity activity) {
        getCurrentSession().merge(activity);
        
    }

    @Override
    public List<Activity> getActivitiesForUser(String userName) {
        Query query = getCurrentSession().getNamedQuery("Activity.getActivityByUser");
        query.setParameter("login", userName);
        List result = query.list();

        return (List<Activity>) result;
    }

    @Override
    public List<ActivityType> getActivityTypes() {
        Query query = getCurrentSession().getNamedQuery("ActivityType.getAll");
        List result = query.list();

        return (List<ActivityType>) result;
    }

    @Override
    public boolean importActivityExist(String importId) {
        Query query = getCurrentSession().getNamedQuery("Activity.importAlreadyExist");
        query.setParameter("importId", importId);
        Activity activity = (Activity) query.uniqueResult();
        if (activity != null) {
            return true;
        }
        return false;
    }

}
