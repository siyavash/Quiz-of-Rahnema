package com.rahnema.controller;

import com.rahnema.model.Account;
import com.rahnema.model.AccountDetail;
import com.rahnema.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

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
    ResponseEntity register(@RequestHeader String androidId) {

        Account account = accountRepository.findByAndroidId(androidId);

        if (accountRepository.findByAndroidId(androidId) == null) {

            account = new Account(androidId, new AccountDetail(100L, 0L, 0L, 1L));
            accountRepository.save(account);

            log.info(account.getDetail().getAccount().getId());
        }

        return ResponseEntity.ok(account.getDetail());
    }

    @PostMapping(path = "/sync-detail", produces = "application/json")
    public @ResponseBody
    ResponseEntity syncDetail(@RequestHeader String androidId,
                              @RequestBody AccountDetail accountDetail) {

        Account account = accountRepository.findByAndroidId(androidId);

        if (account == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        account.getDetail().setCoin(account.getDetail().getCoin() + accountDetail.getCoin());
        account.getDetail().setGem(account.getDetail().getGem() + accountDetail.getGem());
        account.getDetail().setXp(account.getDetail().getXp() + accountDetail.getXp());

        account.getDetail().setLevel(accountDetail.getLevel());

        accountRepository.save(account);

        return ResponseEntity.ok(account.getDetail());
    }
}
