package com.rahnema.model.entity;

import java.io.Serializable;

/**
 * Created by siyavash on 5/10/2017.
 */

public class QuestionAccount implements Serializable {

    private Long id;

    private Long questoinId;

    private Long accountId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestoinId() {
        return questoinId;
    }

    public void setQuestoinId(Long questoinId) {
        this.questoinId = questoinId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
