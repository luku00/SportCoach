package com.sport.coach.controllers;

import com.sport.coach.domain.view.ViewParams;
import com.sport.coach.service.SportCoachService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author luku00
 */
@Controller
@RequestMapping("/user")
public class SportCoachUserController {

    @Autowired
    private SportCoachService sportCoachService;

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
    public ModelAndView resetPassword() {
        ModelAndView model = new ModelAndView("passwordReset");
        return model;
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public ModelAndView resetPasswordRequest(@Valid String loginOrEmail) {
        ModelAndView model = new ModelAndView();
        model.setViewName("passwordReset");
        if (sportCoachService.passwordReset(loginOrEmail)) {
            model.getModel().put(ViewParams.USER_PASSWORD_RESET_REQUESTED, "passwordResetRequested");
        } else {
            model.getModel().put(ViewParams.USER_PASSWORD_REQUEST_FAILED, "passwordResetRequesFailed");
        }
        
        return model;
    }

    @RequestMapping(value = "/passwordReset/{hashCode}", method = RequestMethod.GET)
    public ModelAndView resetPasswordLinked(@PathVariable String hashCode) {
        ModelAndView model = new ModelAndView();
        model.setViewName("passwordChange");

        return model;
    }

    @RequestMapping(value = "/passwordReset/{hashCode}", method = RequestMethod.POST)
    public ModelAndView requestToChangePassword(@PathVariable String hashCode) {
        return null;
    }
}
