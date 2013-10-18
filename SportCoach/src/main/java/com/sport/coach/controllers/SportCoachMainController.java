package com.sport.coach.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
@Controller
@RequestMapping("/")
public class SportCoachMainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
            return "home";
    }
}
