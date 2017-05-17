package com.rahnema.controller;

import com.rahnema.exception.UsernameNotFoundException;
import com.rahnema.model.entity.Account;
import com.rahnema.model.entity.Option;
import com.rahnema.model.entity.Question;
import com.rahnema.repository.AccountRepository;
import com.rahnema.repository.QuestionRepository;
import com.rahnema.utils.CustomQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Math.min;

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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity addQuestion(@RequestBody Question question) {
        for(Option option : question.getOptions()) {
            option.setQuestion(question);
        }

        questionRepository.save(question);

        return ResponseEntity.accepted().body(question);
    }

    @PostMapping(path = "/get")
    public @ResponseBody
    ResponseEntity getQuestions(@RequestHeader String androidId) throws UsernameNotFoundException {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();

        Account account = accountRepository.findByUsername(username);

        if(account == null) {
            throw new UsernameNotFoundException(username);
        }

        //TODO static number
        int numberOfNewQuestions = 10;

        List<Long> newQuestionIds = jdbcTemplate.query(CustomQuery.getNewQuestions,
                                            new Object[] {account.getId(), numberOfNewQuestions},
                                            (rs, rowNum) -> (rs.getLong("id")));
        int numberOfRemainQuestions = numberOfNewQuestions - (int) min(0.8 * numberOfNewQuestions, newQuestionIds.size());

        List<Long> remainQuestions = jdbcTemplate.query(CustomQuery.getDuplicateQuesions,
                                                        new Object[] {account.getId(), numberOfRemainQuestions},
                                                        (rs, rowNum) -> (rs.getLong("id")));
        newQuestionIds.addAll(remainQuestions);

        return ResponseEntity.ok().body(questionRepository.findByInventoryIds(newQuestionIds));
    }
}
