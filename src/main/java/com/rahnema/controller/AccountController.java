package com.rahnema.controller;

import com.rahnema.model.Account;
import com.rahnema.model.AccountDetail;
import com.rahnema.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
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
    AccountRepository accountRepository;

    @PostMapping(path = "register")
    public @ResponseBody
    Account register(@RequestHeader String androidId) {
        Account newAccount = new Account(androidId);
        accountRepository.save(newAccount);
        return newAccount;
    }
}
