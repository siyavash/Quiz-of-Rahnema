package com.rahnema.model;

import java.io.Serializable;

/**
 * Created by siyavash on 5/5/2017.
 */
public class Question implements Serializable {

    Long Id;

    private String text;

    private int difficulty;

    private Long NumberOfSeen;

    private Long correctAnswer;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Long getNumberOfSeen() {
        return NumberOfSeen;
    }

    public void setNumberOfSeen(Long numberOfSeen) {
        NumberOfSeen = numberOfSeen;
    }

    public Long getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Long correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
