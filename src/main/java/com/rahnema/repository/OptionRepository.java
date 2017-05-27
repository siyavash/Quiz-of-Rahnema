package com.rahnema.repository;

import com.rahnema.model.entity.Option;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by siyavash on 5/15/2017.
 */

@Repository
public interface OptionRepository extends CrudRepository<Option, Long> {
}
