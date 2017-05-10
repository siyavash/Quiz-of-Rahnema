package com.rahnema.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by siyavash on 5/5/2017.
 */

@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    private String name;

    public Category() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
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