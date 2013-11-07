/**
 * *************************************************************************************************
 * Copyright 2013 TeliaSonera. All rights reserved.
 *************************************************************************************************
 */
package com.sport.coach.controllers;

import com.sport.coach.domain.user.User;
import com.sport.coach.domain.view.UserView;
import com.sport.coach.mappers.ViewMapper;
import com.sport.coach.service.SportCoachService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String index() {
        return "newAccount";
    }

    @RequestMapping(value = "/new/save", method = RequestMethod.POST)
    public String save(@Valid UserView viewUser) {
        User user = sportCoachService.save(viewMapper.mapToUser(viewUser));
        int aa = 0;
        return null;
    }
}
