package com.rahnema.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by siyavash on 5/5/2017.
 */

@Entity
@Table(name = "option")
public class Option implements Serializable {

    @Column(name = "option_id")
    private Long id;

    @Column(name = "option_text")
    private String text;

    private Question question;

    @Column(name = "option_number_of_hit")
    private Long NumberOfHit;

    public Option() {}

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

    @ManyToOne
    @JoinColumn(name = "option_question")
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Long getNumberOfHit() {
        return NumberOfHit;
    }

    public void setNumberOfHit(Long numberOfHit) {
        NumberOfHit = numberOfHit;
    }
}
