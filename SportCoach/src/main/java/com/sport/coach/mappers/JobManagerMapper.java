package com.sport.coach.mappers;

import com.sport.coach.domain.activity.Plan;
import com.sport.coach.domain.user.User;
import com.sport.jobmanager.common.JobStatus;
import com.sport.jobmanager.common.JobType;
import com.sport.jobmanager.common.domain.Job;

/**
 *
 * @author Lukas Kubicek
 */
public class JobManagerMapper {

    /**
     * Be aware that all other field than status, type, name and email will be
     * overwritten once agent pick up the job
     * @param jobType
     * @param user
     * @param jobIdentifier code specification of the job ... for example
     * password hash
     * @return
     */
    public Job mapToJob(JobType jobType, User user, String jobIdentifier) {
        Job job = new Job();
        job.setJobType(jobType);
        job.setJobStatus(JobStatus.INITIAL);
        job.setUserFirstName(user.getFirstName());
        job.setUserLastName(user.getLastName());
        job.setUserEmail(user.getEmail());
        job.setJobIdentifier(jobIdentifier);
        job.setUserLogin(user.getUserIdentification().getUserLogin());
        return job;
    }

    public Job mapToJob(JobType jobType, User user, String jobIdentifier, Plan plan) {
        Job job = mapToJob(jobType, user, jobIdentifier);
        job.setFromDate(plan.getFromDate());
        job.setToDate(plan.getToDate());
        job.setGoalType(plan.getGoalType().name());
        job.setGoalValue(plan.getGoalValue());
        job.setReward(plan.getReward());
        return job;
    }
}
