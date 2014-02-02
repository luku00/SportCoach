package com.sport.coach.service;

import com.sport.coach.domain.user.User;
import com.sport.coach.domain.view.FileUpload;
import com.sport.coach.error.ClientServerException;
import java.text.ParseException;

/**
 *
 * @author luku00
 */
public interface FileUploadService {

    public void createActivityFromXmlFile(FileUpload uploadedFile, User user,
            String activityType) throws ClientServerException, ParseException;
}
