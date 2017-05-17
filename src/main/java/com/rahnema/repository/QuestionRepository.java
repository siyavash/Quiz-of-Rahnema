package com.rahnema.repository;

import com.rahnema.model.entity.Account;
import com.rahnema.model.entity.Question;
import com.rahnema.utils.CustomQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by siyavash on 5/5/2017.
 */

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

    @Query(CustomQuery.getQuestionsById)
    List<Question> findByInventoryIds(@Param("ids") List<Long> iterable);
}
