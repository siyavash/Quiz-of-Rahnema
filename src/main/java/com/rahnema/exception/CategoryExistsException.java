package com.rahnema.exception;

/**
 * Created by siyavash on 5/27/2017.
 */
public class CategoryExistsException extends UnavailableAbstractException {

    public CategoryExistsException(String error) {
        super("category" + error);
    }
}
