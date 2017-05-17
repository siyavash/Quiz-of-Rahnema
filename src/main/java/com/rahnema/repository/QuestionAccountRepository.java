package com.rahnema.repository;

import com.rahnema.model.entity.QuestionAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by siyavash on 5/17/2017.
 */

@Repository
public interface QuestionAccountRepository extends CrudRepository<QuestionAccount, Long> {
}
