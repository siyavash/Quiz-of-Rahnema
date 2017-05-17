package com.rahnema.controller;

import com.rahnema.exception.UsernameNotFoundException;
import com.rahnema.model.entity.Account;
import com.rahnema.model.entity.MatchDetail;
import com.rahnema.repository.AccountRepository;
import com.rahnema.repository.MatchDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by siyavash on 5/5/2017.
 */

@Controller
@RequestMapping(path = "/match")
public class MatchController {

    @Autowired
    private MatchDetailRepository matchDetailRepository;

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping(path = "/add", produces = "application/json")
    public @ResponseBody
    ResponseEntity addMatch(@RequestBody MatchDetail matchDetail) {
        matchDetailRepository.save(matchDetail);

        return ResponseEntity.accepted().body(null);
    }

    @PostMapping(path = "/get")
    public @ResponseBody
    ResponseEntity getMatch(@RequestHeader String androidId) throws UsernameNotFoundException {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();

        Account account = accountRepository.findByUsername(username);

        if(account == null) {
            throw new UsernameNotFoundException(username);
        }

        return ResponseEntity.ok().body(matchDetailRepository.findAll());
    }
}
