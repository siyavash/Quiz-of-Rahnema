package com.rahnema.controller;

import com.rahnema.model.MatchDetail;
import com.rahnema.repository.MatchDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by siyavash on 5/5/2017.
 */

@Controller
@RequestMapping(path = "/match")
public class MatchController {

    @Autowired
    private MatchDetailRepository matchDetailRepository;

    @PostMapping(path = "/add", produces = "application/json")
    public @ResponseBody
    ResponseEntity addMatch(@RequestBody MatchDetail matchDetail) {
        matchDetailRepository.save(matchDetail);

        return ResponseEntity.accepted().body(null);
    }
}
