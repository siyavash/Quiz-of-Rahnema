package com.rahnema.exception;

/**
 * Created by doost on 5/13/2017.
 */
public class UsernameNotFoundException extends NotFoundAbstractException {

    public UsernameNotFoundException(String error) {
        super("username " + error);
    }
}
