package com.rahnema.controller;

import com.rahnema.model.Account;
import com.rahnema.model.AccountDetail;
import com.rahnema.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by siyavash on 5/3/2017.
 */

@Controller
@RequestMapping(path = "/user")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    private org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AccountController.class);

    @PostMapping(path = "/register")
    public @ResponseBody
    AccountDetail register(@RequestHeader String androidId) {

        Account account = accountRepository.findByAndroidId(androidId);

        if(accountRepository.findByAndroidId(androidId) == null) {

            account = new Account(androidId, new AccountDetail(100L, 0L, 0L, 1L));
            accountRepository.save(account);

            log.info(account.getDetail().getAccount().getId());
        }

        return account.getDetail();
    }
}
