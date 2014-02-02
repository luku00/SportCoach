package com.sport.coach.error;

/**
 *
 * @author Lukas Kubicek
 */
public class ClientServerException extends Exception {

    public ClientServerException() {
        super();
    }

    public ClientServerException(String message) {
        super(message);
    }
}
