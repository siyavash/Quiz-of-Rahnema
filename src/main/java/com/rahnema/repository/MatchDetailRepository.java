package com.rahnema.repository;

import com.rahnema.model.MatchDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by siyavash on 5/5/2017.
 */

@Repository
public interface MatchDetailRepository extends CrudRepository<MatchDetail, Long> {
}
