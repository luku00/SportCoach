package com.sport.coach.service.impl;

import com.sport.coach.domain.account.Account;
import com.sport.coach.domain.activity.Plan;
import com.sport.coach.domain.activity.ValueType;
import com.sport.coach.domain.user.Role;
import com.sport.coach.domain.user.User;
import com.sport.coach.error.ClientServerException;
import com.sport.coach.mappers.JobManagerMapper;
import com.sport.coach.repository.dao.SportCoachDao;
import com.sport.coach.service.SportCoachSecurityService;
import com.sport.coach.service.SportCoachService;
import com.sport.jobmanager.common.JobStatus;
import com.sport.jobmanager.common.JobType;
import com.sport.jobmanager.common.domain.Job;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public class SportCoachServiceImpl implements SportCoachService {

    private SportCoachDao sportCoachDao;
    private JobManagerMapper jobManagerMapper;
    private SportCoachSecurityService securityService;

    @Override
    public User save(User user, Integer accountId) throws ClientServerException {
        if (user.getRole() == Role.REQUESTOR) {
            createRequestorUser(user);
        } else if (user.getRole() == Role.BASIC_USER) {
            createBasicUser(user, accountId);
        }
        return user;
    }

    private void createBasicUser(User user, Integer accountId) throws ClientServerException {
        if (accountId == null) {
            throw new ClientServerException("Login error");
        }
        sportCoachDao.updateAccountWithNewUser(user, accountId);
        createNewJob(JobType.EMAIL_NEW_SUB_USER, user, null, null);
    }

    private void createRequestorUser(User user) {
        Account account = new Account();
        account.populateNewAccount(user);
        sportCoachDao.save(account);
    }

    public void setSportCoachDao(SportCoachDao sportCoachDao) {
        this.sportCoachDao = sportCoachDao;
    }

    public void setSecurityService(SportCoachSecurityService securityService) {
        this.securityService = securityService;
    }

    public void setJobManagerMapper(JobManagerMapper jobManagerMapper) {
        this.jobManagerMapper = jobManagerMapper;
    }

    @Override
    public boolean checkIfLoginExists(String login) {
        return sportCoachDao.userExist(login);
    }

    @Override
    public User authenticateUser(String login, String password) {
        User authenticatedUser = sportCoachDao.autehenticateUser(login, password);
        if (authenticatedUser != null) {
            authenticatedUser.getUserIdentification().secure();
        }
        return authenticatedUser;
    }

    @Override
    public User getUser(String login) {
        return sportCoachDao.getUser(login);
    }

    @Override
    @Transactional
    public User updateUserData(User user, String login) {
        User storedUser = sportCoachDao.getUser(login);
        storedUser.setNewUserData(user);
        return storedUser;
    }

    /**
     * This will create new Job for later processing
     *
     * @param jobType
     * @param user
     * @param jobIdentifier
     */
    private void createNewJob(JobType jobType, User user, String jobIdentifier, Plan plan) {
        Job job;
        if (plan == null) {
            job = jobManagerMapper.mapToJob(jobType, user, jobIdentifier);
        } else {
            job = jobManagerMapper.mapToJob(jobType, user, jobIdentifier, plan);
        }
        sportCoachDao.save(job);
    }

    @Override
    public boolean passwordReset(String loginOrEmail) {
        User user;
        if (isEmail(loginOrEmail)) {
            user = sportCoachDao.getUserByEmail(loginOrEmail);
        } else {
            user = sportCoachDao.getUser(loginOrEmail);
        }
        if (user != null) {
            createNewJob(JobType.EMAIL_RESET_PASSWORD, user,
                    securityService.getHashedString(String.valueOf(user.getUserId())), null);
            return true;
        }
        return false;
    }

    private boolean isEmail(String loginOrEmail) {
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher m = p.matcher(loginOrEmail);
        return m.matches();
    }

    @Override
    public String getUserEmail(String jobIdentifier) {
        Job job = sportCoachDao.getJobByJobIdentifier(jobIdentifier);
        if (job != null) {
            return job.getUserEmail();
        }
        return null;
    }

    @Override
    @Transactional
    public void passwordChange(String newPassword, String jobIdentifier) {
        Job job = sportCoachDao.getJobByJobIdentifier(jobIdentifier);
        User user = sportCoachDao.getUserByEmail(job.getUserEmail());
        user.getUserIdentification().setUserPassword(securityService.hashPassword(newPassword));

        // after password change job identifier needs to be removed for security reason
        job.setJobIdentifier(null);
        job.setJobStatus(JobStatus.POST_COMPLETED);
    }

    @Override
    public void createNewPlan(Date fromDate, Date toDate, String goal, String goalType,
            String userName, String reward) {
        ValueType valueType = ValueType.fromString(goalType);
        User user = sportCoachDao.getUser(userName);
        Plan plan = new Plan(new Date(), fromDate, toDate, valueType, goal, user, Integer.parseInt(reward));
        sportCoachDao.savePlan(plan);
        createNewJob(JobType.EMAIL_NEW_PLAN, user, null, plan);
    }
}
