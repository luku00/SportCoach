/**
 * *************************************************************************************************
 * Copyright 2013 TeliaSonera. All rights reserved.
 *************************************************************************************************
 */
package com.sport.coach.controllers;

import com.sport.coach.domain.user.Role;
import com.sport.coach.domain.user.User;
import com.sport.coach.domain.view.UserInfo;
import com.sport.coach.domain.view.UserView;
import com.sport.coach.domain.view.ViewParams;
import com.sport.coach.error.ClientServerException;
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
import org.joda.time.LocalDate;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek.work@gmail.com>
 */
@Controller
@RequestMapping("/account")
@SessionAttributes({"userData", "userInfo"})
public class SportCoachAccountController {

    private static final int DAYS_IN_MONTH = 31;
    private static final int MONTHS_IN_YEAR = 12;
    private static final int YEARS = 50;

    @Autowired
    private UserView userView;

    @Autowired
    private UserInfo userInfo;

    @Autowired
    private ViewMapper viewMapper;

    @Autowired
    private SportCoachService sportCoachService;

    @Autowired
    private SportCoachSecurityService sportCoachSecurityService;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("newAccount", ViewParams.NEW_ACCOUNT_ROLES, createListOfRoles());
        loadDefaultNewAccountParams(model);
        return model;
    }

    @RequestMapping(value = "/new/save", method = RequestMethod.POST)
    public ModelAndView save(@Valid UserView viewUser) {
        ModelAndView model = new ModelAndView();
        model.getModel().put(ViewParams.NEW_ACCOUNT_ROLES, createListOfRoles());
        model.setViewName("newAccount");
        if (sportCoachService.checkIfLoginExists(viewUser.getLogin())) {
            model.getModel().put(ViewParams.NEW_ACCOUNT_EXISTING_LOGIN, "loginExist");
            model.getModel().put(ViewParams.NEW_ACCOUNT_USER_VIEW, viewUser);

        } else {
            viewUser.setPassword(sportCoachSecurityService.hashPassword(viewUser.getPassword()));
            User user = sportCoachService.save(viewMapper.mapToUser(viewUser));
            model.getModel().put(ViewParams.NEW_ACCOUNT_USER_CREATED, "userCreated");
        }

        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminOwnAccount() throws ClientServerException {
        ModelAndView model = new ModelAndView("adminAccount");
        userView = viewMapper.mapToUserView(sportCoachService.getUser(userInfo.getLogin()), userView);
        model.addObject("userData", userView);
        return model;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public ModelAndView changeAccountData(@Valid UserView viewUser) throws ClientServerException {
        ModelAndView model = new ModelAndView("home");
        User updatedUser = sportCoachService.updateUserData(viewMapper.mapToUser(viewUser), userInfo.getLogin());
        userInfo = viewMapper.mapUserToUserInfo(updatedUser);
        model.addObject("userInfo", userInfo);
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView authenticate(@Valid UserView viewUser) {
        ModelAndView model = new ModelAndView();
        viewUser.setPassword(sportCoachSecurityService.hashPassword(viewUser.getPassword()));
        User authenticatedUser = sportCoachService.authenticateUser(viewUser.getLogin(), viewUser.getPassword());
        if (authenticatedUser == null) {
            model.setViewName("login");
            model.getModel().put(ViewParams.LOGIN_ERROR, "loginError");
        } else {
            model.setViewName("home");
            userInfo = viewMapper.mapUserToUserInfo(authenticatedUser);
            model.addObject("userInfo", userInfo);
        }

        return model;
    }

    private List<String> createListOfRoles() {
        List<String> roles = new ArrayList<>();
        for (Role r : Role.values()) {
            roles.add(r.name());
        }
        return roles;
    }

    private void loadDefaultNewAccountParams(ModelAndView model) {
        model.getModel().put(ViewParams.NEW_ACCOUNT_DAYS, createListOfDays());
        model.getModel().put(ViewParams.NEW_ACCOUNT_MONTHS, createListOfMonths());
        model.getModel().put(ViewParams.NEW_ACCOUNT_YEARS, createListOfYears());
    }

    private List<String> createListOfDays() {
        List<String> days = new ArrayList<>();
        for (int i = 1; i <= DAYS_IN_MONTH; i++) {
            days.add(String.valueOf(i));
        }
        return days;
    }

    private List<String> createListOfMonths() {
        List<String> months = new ArrayList<>();
        for (int i = 1; i <= MONTHS_IN_YEAR; i++) {
            months.add(String.valueOf(i));
        }
        return months;
    }

    private List<String> createListOfYears() {
        List<String> years = new ArrayList<>();
        LocalDate localDate = new LocalDate();
        int currentYear = localDate.getYear();
        for (int i = 1; i <= YEARS; i++) {
            years.add(String.valueOf(currentYear - i));
        }
        return years;
    }
}
