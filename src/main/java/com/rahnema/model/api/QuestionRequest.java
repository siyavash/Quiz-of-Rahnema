package com.rahnema.model.api;

import java.io.Serializable;
import java.util.List;

/**
 * Created by siyavash on 5/10/2017.
 */
public class QuestionRequest implements Serializable {

    private List<Long> seenQuestions;

    private List<Long> hitOptions;

    private List<Long> unseen;

    public List<Long> getSeenQuestions() {
        return seenQuestions;
    }

    public void setSeenQuestions(List<Long> seenQuestions) {
        this.seenQuestions = seenQuestions;
    }

    public List<Long> getHitOptions() {
        return hitOptions;
    }

    public void setHitOptions(List<Long> hitOptions) {
        this.hitOptions = hitOptions;
    }

    public List<Long> getUnseen() {
        return unseen;
    }

    public void setUnseen(List<Long> unseen) {
        this.unseen = unseen;
    }
}
