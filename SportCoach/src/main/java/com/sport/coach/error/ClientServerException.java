/***************************************************************************************************
 * Copyright 2013 TeliaSonera. All rights reserved.
 **************************************************************************************************/
package com.sport.coach.error;

/**
 *
 * @author Lukas Kubicek <lukas.kubicek@netcom-gsm.com>
 */
public class ClientServerException extends Exception {

    public ClientServerException() {
        super();
    }

    public ClientServerException(String message) {
        super(message);
    }
}
