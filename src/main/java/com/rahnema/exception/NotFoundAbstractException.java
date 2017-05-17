package com.rahnema.exception;

/**
 * Created by siyavash on 5/13/2017.
 */
public abstract class NotFoundAbstractException extends Exception {

    public NotFoundAbstractException(String error) {
        super(error + " not found.");
    }
}
