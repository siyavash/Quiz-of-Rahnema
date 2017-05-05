package com.rahnema.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by siyavash on 5/5/2017.
 */

@Entity
@Table(name = "match_detail")
public class MatchDetail implements Serializable {

    @Column(name = "match_id")
    private int id;

    @Column(name = "match_type")
    private int type;

    @Column(name = "match_maximum_time")
    private int maximumTime;

    @Column(name = "match_decreasing_time")
    private int decreasingTime;

    @Column(name = "match_number_of_question")
    private int numberOfQuestion;

    MatchDetail() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
