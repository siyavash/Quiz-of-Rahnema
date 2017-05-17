package com.rahnema.model.api;

import com.rahnema.model.entity.Question;

import java.io.Serializable;
import java.util.List;

/**
 * Created by siyavash on 5/10/2017.
 */
public class QuestionResponse implements Serializable {

    private List<Question> questions;

    private List<Long> deleted;

    public QuestionResponse() {}

    public QuestionResponse(List<Question> questions) {
        this.questions = questions;
    }

    public QuestionResponse(List<Question> questions, List<Long> deleted) {
        this.questions = questions;
        this.deleted = deleted;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Long> getDeleted() {
        return deleted;
    }

    public void setDeleted(List<Long> deleted) {
        this.deleted = deleted;
    }
}
