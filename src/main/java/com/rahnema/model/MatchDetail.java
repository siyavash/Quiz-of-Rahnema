package com.rahnema.model;

import java.io.Serializable;

/**
 * Created by siyavash on 5/5/2017.
 */
public class MatchDetail implements Serializable {

    private int id;

    private int type;

    private int maximumTime;

    private int decreasingTime;

    private int numberOfQuestion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMaximumTime() {
        return maximumTime;
    }

    public void setMaximumTime(int maximumTime) {
        this.maximumTime = maximumTime;
    }

    public int getDecreasingTime() {
        return decreasingTime;
    }

    public void setDecreasingTime(int decreasingTime) {
        this.decreasingTime = decreasingTime;
    }

    public int getNumberOfQuestion() {
        return numberOfQuestion;
    }

    public void setNumberOfQuestion(int numberOfQuestion) {
        this.numberOfQuestion = numberOfQuestion;
    }
}
