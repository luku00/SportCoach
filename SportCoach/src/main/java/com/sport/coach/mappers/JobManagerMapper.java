package com.sport.coach.mappers;

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
     */
    public Job mapToJob(JobType jobType, User user) {
        Job job = new Job();
        job.setJobType(jobType);
        job.setJobStatus(JobStatus.INITIAL);
        job.setUserFirstName(user.getFirstName());
        job.setUserLastName(user.getLastName());
        job.setUserEmail(user.getEmail());
        return job;
    }
}
