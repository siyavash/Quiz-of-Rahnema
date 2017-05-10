package com.rahnema.model.api;

import java.io.Serializable;
import java.util.List;

/**
 * Created by siyavash on 5/10/2017.
 */
public class QuestionRequest implements Serializable {

    private List<Long> seen;

    private List<Long> unseen;

    public List<Long> getSeen() {
        return seen;
    }

    public void setSeen(List<Long> seen) {
        this.seen = seen;
    }

    public List<Long> getUnseen() {
        return unseen;
    }

    public void setUnseen(List<Long> unseen) {
        this.unseen = unseen;
    }
}
