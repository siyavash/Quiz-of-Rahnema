package com.rahnema.repository;

import com.rahnema.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by siyavash on 5/3/2017.
 */

@Repository
public interface AccountRepository extends CrudRepository <Account, Long> {

    Account findByAndroidId(String androidId);
}
