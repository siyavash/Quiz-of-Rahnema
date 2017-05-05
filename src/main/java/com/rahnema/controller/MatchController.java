package com.rahnema.controller;

import com.rahnema.model.Account;
import com.rahnema.model.MatchDetail;
import com.rahnema.repository.AccountRepository;
import com.rahnema.repository.MatchDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

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
    ResponseEntity getMatch(@RequestHeader String androidId) {
        Account account = accountRepository.findByAndroidId(androidId);

        if(account == null) {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok().body(matchDetailRepository.findAll());
    }
}
