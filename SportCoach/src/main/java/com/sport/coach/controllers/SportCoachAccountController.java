/**
 * *************************************************************************************************
 * Copyright 2013 TeliaSonera. All rights reserved.
 *************************************************************************************************
 */
package com.sport.coach.controllers;

import com.sport.coach.domain.user.Role;
import com.sport.coach.domain.user.User;
import com.sport.coach.domain.view.UserView;
import com.sport.coach.mappers.ViewMapper;
import com.sport.coach.service.SportCoachSecurityService;
import com.sport.coach.service.SportCoachService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek.work@gmail.com>
 */
@Controller
@RequestMapping("/account")
public class SportCoachAccountController {

    @Autowired
    private ViewMapper viewMapper;

    @Autowired
    private SportCoachService sportCoachService;

    @Autowired
    private SportCoachSecurityService sportCoachSecurityService;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("newAccount", "roles", createListOfRoles());
    }

    @RequestMapping(value = "/new/save", method = RequestMethod.POST)
    public ModelAndView save(@Valid UserView viewUser) {
        ModelAndView model = new ModelAndView();
        model.setViewName("newAccount");
        model.getModel().put("roles", createListOfRoles());

        if (sportCoachService.checkIfLoginExists(viewUser.getLogin())) {
            model.getModel().put("loginExist", "Login exists");
            model.getModel().put("userV", viewUser);
        } else {
            viewUser.setPassword(sportCoachSecurityService.hashPassword(viewUser.getPassword()));
            User user = sportCoachService.save(viewMapper.mapToUser(viewUser));
        }

        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String authenticate(@Valid UserView viewUser) {
        return null;
    }

    private List<String> createListOfRoles() {
        List<String> roles = new ArrayList<>();
        for (Role r : Role.values()) {
            roles.add(r.name());
        }
        return roles;
    }
}
