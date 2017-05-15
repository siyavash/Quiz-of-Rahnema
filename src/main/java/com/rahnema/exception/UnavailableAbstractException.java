package com.rahnema.exception;

/**
 * Created by siyavash on 5/15/2017.
 */
public abstract class UnavailableAbstractException extends Exception {
    private UnavailableAbstractException(String error) {
        super(error + " already exist.");
    }
}
