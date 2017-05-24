package com.rahnema.exception;

import com.rahnema.model.entity.Option;

/**
 * Created by siyavash on 5/24/2017.
 */
public class OptionNotFoundException extends NotFoundAbstractException {

    public OptionNotFoundException(String error) {
        super("Option with id " + error);
    }
}
