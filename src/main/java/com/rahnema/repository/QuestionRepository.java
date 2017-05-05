package com.rahnema.repository;

import com.rahnema.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by siyavash on 5/5/2017.
 */

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
}
