package com.rahnema.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by siyavash on 5/5/2017.
 */

@Entity
@Table(name = "question")
public class Question implements Serializable {

    @Column(name = "question_id")
    private Long id;

    @Column(name = "question_text")
    private String text;

    @Column(name = "question_difficulty")
    private int difficulty;

    @Column(name = "question_number_of_seen")
    private Long NumberOfSeen;

    @Column(name = "question_correct_answer")
    private Long correctAnswer;

    Question() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
