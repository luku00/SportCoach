package com.sport.coach.repository;

import com.sport.coach.repository.dao.SportCoachDao;
import com.sport.coach.repository.dao.SportCoachDaoImpl;
import static org.junit.Assert.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
@ContextConfiguration(locations = {"classpath:est.xml"})
public class RepositoryTest {

    @Autowired
    private SessionFactory sessionFactory;

    public void initTest() {
        SportCoachDao sc = new SportCoachDaoImpl();
        int a = 0;
        //assertNotNull(sessionFactory);
    }
}
