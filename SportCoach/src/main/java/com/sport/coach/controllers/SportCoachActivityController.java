package com.sport.coach.controllers;

import com.sport.coach.domain.view.FileUpload;
import com.sport.coach.domain.view.ViewParams;
import com.sport.coach.service.FileUploadService;
import com.sport.coach.service.SportCoachActivityService;
import com.sport.coach.service.SportCoachService;
import com.sport.coach.validators.FileUploadValidator;
import java.io.IOException;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author luku00
 */
@Controller
@RequestMapping("/activity")
public class SportCoachActivityController extends BaseController {

    @Autowired
    FileUploadValidator fileUploadValidator;

    @Autowired
    FileUploadService fileUploadService;

    @Autowired
    private SportCoachService sportCoachService;

    @Autowired
    private SportCoachActivityService activityService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView showActivities() {
        ModelAndView model = new ModelAndView("activity");
        model.addObject(ViewParams.ACTIVITY_TYPES, activityService.getAllActivityTypes());
        
        return model;
    }

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public ModelAndView uploadFile(@ModelAttribute("uploadedFile") FileUpload uploadedFile,
            BindingResult result, String activityType) throws IOException, ParseException {

        fileUploadValidator.validate(uploadedFile, result);

        if (result.hasErrors()) {
            return new ModelAndView("activity");
        }
        fileUploadService.createActivityFromXmlFile(uploadedFile, sportCoachService.getUser(getLoggedUserName()),
                activityType);

        return new ModelAndView("activity");
    }
}
