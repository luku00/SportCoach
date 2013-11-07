/***************************************************************************************************
 * Copyright 2013 TeliaSonera. All rights reserved.
 **************************************************************************************************/
package com.sport.coach.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
@ControllerAdvice
public class SportCoachControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleClientException(final Exception exception) {
        return new ModelAndView("error", "message", exception.getLocalizedMessage());
    }
}
