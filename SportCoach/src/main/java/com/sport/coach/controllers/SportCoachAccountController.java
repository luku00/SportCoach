/**
 * *************************************************************************************************
 * Copyright 2013 TeliaSonera. All rights reserved.
 *************************************************************************************************
 */
package com.sport.coach.controllers;

import com.sport.coach.domain.user.Role;
import com.sport.coach.domain.user.User;
import com.sport.coach.domain.view.UserView;
import com.sport.coach.domain.view.ViewParams;
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

/**
 *
 * @author Lukas Kubicek <lukas.kubicek.work@gmail.com>
 */
@Controller
@RequestMapping("/account")
public class SportCoachAccountController {

    private static final int DAYS_IN_MONTH = 31;
    private static final int MONTHS_IN_YEAR = 12;
    private static final int YEARS = 50;

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
        model.setViewName("newAccount");
        model.getModel().put(ViewParams.NEW_ACCOUNT_ROLES, createListOfRoles());

        if (sportCoachService.checkIfLoginExists(viewUser.getLogin())) {
            model.getModel().put(ViewParams.NEW_ACCOUNT_EXISTING_LOGIN, "Login exists");
            model.getModel().put(ViewParams.NEW_ACCOUNT_USER_VIEW, viewUser);
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
