package com.rahnema.model.entity;

import jdk.nashorn.internal.runtime.QuotedStringTokenizer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    private List<Question> questions;

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

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
