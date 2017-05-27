package com.rahnema.model.entity;

import com.rahnema.model.AbstractBaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by siyavash on 5/10/2017.
 */

@Entity
@Table(name = "question_account")
public class QuestionAccount extends AbstractBaseEntity implements Serializable {

    @Column(name = "question_account_id")
    private Long id;

    @Column(name = "question_account_question_id")
    private Long questionId;

    @Column(name = "question_account_account_id")
    private Long accountId;

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
