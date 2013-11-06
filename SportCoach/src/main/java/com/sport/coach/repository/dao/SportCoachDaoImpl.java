package com.sport.coach.repository.dao;

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
}
