package com.rahnema.model;

import java.io.Serializable;

/**
 * Created by siyavash on 5/5/2017.
 */
public class Option implements Serializable {

    private Long id;

    private String text;

    private Long NumberOfHit;

    Option() {}

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

    public Long getNumberOfHit() {
        return NumberOfHit;
    }

    public void setNumberOfHit(Long numberOfHit) {
        NumberOfHit = numberOfHit;
    }
}
