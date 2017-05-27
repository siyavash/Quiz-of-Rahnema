package com.rahnema.exception;

/**
 * Created by doost on 5/27/2017.
 */
public class CategoryExistsException extends UnavailableAbstractException {

    public CategoryExistsException(String error) {
        super("category" + error);
    }
}
