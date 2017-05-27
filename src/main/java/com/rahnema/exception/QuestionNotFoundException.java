package com.rahnema.exception;

/**
 * Created by siyavash on 5/20/2017.
 */
public class QuestionNotFoundException extends NotFoundAbstractException {
    public QuestionNotFoundException(String error) {
        super("question with id " + error);
    }
}
