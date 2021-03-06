/***************************************************************************************************
 * Copyright 2013 TeliaSonera. All rights reserved.
 **************************************************************************************************/
package com.sport.coach.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
@ControllerAdvice
public class SportCoachControllerAdvice {

    static Logger LOGGER = LoggerFactory.getLogger("error");

    @ExceptionHandler(Exception.class)
    public ModelAndView handleClientException(final Exception exception) {
        LOGGER.error("error :", exception);
        return new ModelAndView("error", "message", exception.getLocalizedMessage());
    }
}
