package com.rahnema.controller;

import com.rahnema.exception.UsernameExistsException;
import com.rahnema.exception.UsernameNotFoundException;
import com.rahnema.model.entity.Account;
import com.rahnema.model.entity.AccountDetail;
import com.rahnema.repository.AccountRepository;
import com.rahnema.utils.GameConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    ResponseEntity register(@RequestHeader String androidId,
                            @RequestHeader String username,
                            @RequestHeader String password) throws UsernameExistsException {

        Account account = accountRepository.findByUsername(username);
        log.info(username);
        log.info(password);
        log.info(androidId);

        if (account != null) {
            throw new UsernameExistsException(username);
        }

        account = new Account(androidId, new AccountDetail(GameConfig.baseCoin,
                                                           GameConfig.baseGem,
                                                           GameConfig.baseXp,
                                                           GameConfig.baseLevel));
        account.setUsername(username);
        account.setPassword(password);
        accountRepository.save(account);

        log.info(account.getDetail().getAccount().getId());

        return ResponseEntity.ok(account.getDetail());
    }

    @PostMapping(path = "/sync-detail")
    public @ResponseBody
    ResponseEntity syncDetail(@RequestBody AccountDetail accountDetail) throws UsernameNotFoundException {

        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();

        Account account = accountRepository.findByUsername(username);


        if (account == null) {
            throw new UsernameNotFoundException(username);
        }

        account.getDetail().setCoin(account.getDetail().getCoin() + accountDetail.getCoin());
        account.getDetail().setGem(account.getDetail().getGem() + accountDetail.getGem());
        account.getDetail().setXp(account.getDetail().getXp() + accountDetail.getXp());

        account.getDetail().setLevel(accountDetail.getLevel());

        accountRepository.save(account);

        return ResponseEntity.ok(account.getDetail());
    }

    @PostMapping(path = "/get")
    public @ResponseBody
    ResponseEntity getAccount() throws UsernameNotFoundException {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();

        Account account = accountRepository.findByUsername(username);

        if(account == null) {
            throw new UsernameNotFoundException(username);
        }

        return ResponseEntity.ok().body(account);
    }
}
