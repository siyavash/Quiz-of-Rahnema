package com.rahnema.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

    @Column(name = "option_created_at")
    private Date created;

    @Column(name = "option_updated_at")
    private Date updated;

    @PrePersist
    protected void onCreate() {
        created = updated = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Option() {}

    public Option(String text, Question question) {
        this.text = text;
        this.setQuestion(question);
    }

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
    @JsonBackReference
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
