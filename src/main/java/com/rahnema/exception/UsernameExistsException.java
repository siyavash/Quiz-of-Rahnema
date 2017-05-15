package com.rahnema.exception;

/**
 * Created by doost on 5/15/2017.
 */
public class UsernameExistsException extends UnavailableAbstractException {
    public UsernameExistsException(String error) {
        super("username " + error);
    }
}
