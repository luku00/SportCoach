package com.sport.coach.domain.view;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author luku00
 */
public class FileUpload {

    MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

}
