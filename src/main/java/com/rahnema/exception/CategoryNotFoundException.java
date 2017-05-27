package com.rahnema.exception;

/**
 * Created by siyavash on 5/27/2017.
 */
public class CategoryNotFoundException extends NotFoundAbstractException {

    public CategoryNotFoundException(String error) {
        super("category " + error);
    }
}
