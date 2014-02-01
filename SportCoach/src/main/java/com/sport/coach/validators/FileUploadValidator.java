package com.sport.coach.validators;

import com.sport.coach.domain.view.FileUpload;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author luku00
 */
public class FileUploadValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return false;
    }

    @Override
    public void validate(Object uploadedFile, Errors errors) {
        FileUpload file = (FileUpload) uploadedFile;
        if (file.getFile().getSize() == 0) {
            errors.rejectValue("file", "uploadForm.selectFile",
                    "Please select a file!");
        }
//        String fileName = file.getFile().getName();
//        if (!fileName.contains(".tcx")) {
//            errors.rejectValue("file", "uploadForm.selectFile",
//                    "Please select a *.tcx file!");
//        }
    }

}
