package com.rahnema.model;

import java.io.Serializable;

/**
 * Created by siyavash on 5/5/2017.
 */
public class Category implements Serializable {

    Long id;

    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
