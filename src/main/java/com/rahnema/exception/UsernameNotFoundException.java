package com.rahnema.exception;

/**
 * Created by siyavash on 5/13/2017.
 */
public class UsernameNotFoundException extends NotFoundAbstractException {

    public UsernameNotFoundException(String error) {
        super("username " + error);
    }
}
