package com.sport.coach.controllers;

import com.sport.coach.domain.view.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
@Controller
@RequestMapping("/")
public class SportCoachMainController {

    @Autowired
    UserInfo userInfo;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.setViewName("home");
        model.addObject("userInfo", userInfo);
        return model;
    }
}
