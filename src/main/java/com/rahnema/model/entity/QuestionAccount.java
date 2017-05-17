package com.rahnema.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by siyavash on 5/10/2017.
 */

@Entity
@Table(name = "question_account")
public class QuestionAccount implements Serializable {

    @Column(name = "question_account_id")
    private Long id;

    @Column(name = "question_account_question_id")
    private Long questionId;

    @Column(name = "question_account_account_id")
    private Long accountId;

    @Column(name = "question_account_created_at")
    private Date created;

    @Column(name = "question_account_updated_at")
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

    public QuestionAccount() {}

    public QuestionAccount(Long questionId, Long accountId) {
        this.questionId = questionId;
        this.accountId = accountId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
