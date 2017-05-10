package com.rahnema.controller;

import com.rahnema.model.entity.Account;
import com.rahnema.model.entity.Option;
import com.rahnema.model.entity.Question;
import com.rahnema.repository.AccountRepository;
import com.rahnema.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by siyavash on 5/6/2017.
 */

@Controller
@RequestMapping(path = "/question")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity addQuestions(@RequestBody Question question) {
        for(Option option : question.getOptions()) {
            option.setQuestion(question);
        }

        questionRepository.save(question);

        return ResponseEntity.accepted().body(question);
    }

    @PostMapping(path = "/get")
    public @ResponseBody
    ResponseEntity getQuestion(@RequestHeader String androidId) {
        Account account = accountRepository.findByAndroidId(androidId);

        if(account == null) {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok().body(questionRepository.findAll());
    }
}
