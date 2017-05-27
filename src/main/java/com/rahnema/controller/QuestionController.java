package com.rahnema.controller;

import com.rahnema.exception.CategoryNotFoundException;
import com.rahnema.exception.OptionNotFoundException;
import com.rahnema.exception.QuestionNotFoundException;
import com.rahnema.exception.UsernameNotFoundException;
import com.rahnema.model.api.QuestionRequest;
import com.rahnema.model.api.QuestionResponse;
import com.rahnema.model.entity.Account;
import com.rahnema.model.entity.Option;
import com.rahnema.model.entity.Question;
import com.rahnema.model.entity.QuestionAccount;
import com.rahnema.repository.*;
import com.rahnema.utils.CustomQuery;
import com.rahnema.utils.GameConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    private QuestionAccountRepository questionAccountRepository;

    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AccountController.class);

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity addQuestion(@RequestBody Question question) throws CategoryNotFoundException {

        if(question.getCategory() != null && categoryRepository.findByName(question.getCategory().getName()) != null) {
            throw new CategoryNotFoundException(question.getCategory().getName());
        }

        for(Option option : question.getOptions()) {
            option.setQuestion(question);
        }

        questionRepository.save(question);

        return ResponseEntity.accepted().body(question);
    }

    @PostMapping(path = "/get/{category}")
    public @ResponseBody
    ResponseEntity getQuestions(@RequestHeader String androidId,
                                @PathVariable String category,
                                @RequestBody QuestionRequest syncQuestions) throws UsernameNotFoundException,
                                                                                    QuestionNotFoundException,
                                                                                    OptionNotFoundException {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();

        Account account = accountRepository.findByUsername(username);

        log.info(category);

        if(account == null) {
            throw new UsernameNotFoundException(username);
        }

        for(Long id : syncQuestions.getSeenQuestions()) {
            try {
                Question question = questionRepository.findOne(id);
                if(question.getNumberOfSeen() == null) {
                    question.setNumberOfSeen(0L);
                }

                question.setNumberOfSeen(question.getNumberOfSeen() + 1);

                log.info(id + "  ___");
                questionAccountRepository.save(new QuestionAccount(question.getId(), account.getId()));
                questionRepository.save(question);
            }
            catch (Exception e) {
                throw new QuestionNotFoundException(id.toString());
            }

        }

        log.info("+++++++== after seen");

        for(Long id : syncQuestions.getHitOptions()) {
            try {
                Option option = optionRepository.findOne(id);

                log.info("after creation");
                if(option.getNumberOfHit() == null) {
                    option.setNumberOfHit(0L);
                }

                option.setNumberOfHit(option.getNumberOfHit() + 1);

                optionRepository.save(option);
            }
            catch (Exception e) {
                throw new OptionNotFoundException(id.toString());
            }
        }

        log.info("++++++++++++++ here");

        int numberOfNewQuestions = GameConfig.numberOfFreshQuestions - syncQuestions.getUnseen().size();
        log.info("#################### " + numberOfNewQuestions);

        if(numberOfNewQuestions <= 0) {
            return ResponseEntity.ok().body(new QuestionResponse(new ArrayList<Question>(), new ArrayList<Long>()));
        }

        List<Long> newQuestionIds = jdbcTemplate.query(CustomQuery.getNewQuestions,
                                                        new Object[] {account.getId(), numberOfNewQuestions},
                                                        (rs, rowNum) -> (rs.getLong("id")));
        int numberOfRemainQuestions = numberOfNewQuestions - (int) min(0.8 * numberOfNewQuestions, newQuestionIds.size());

        List<Long> remainQuestions = jdbcTemplate.query(CustomQuery.getDuplicateQuestions,
                                                        new Object[] {account.getId(), numberOfRemainQuestions},
                                                        (rs, rowNum) -> (rs.getLong("question_id")));
        newQuestionIds.addAll(remainQuestions);

        return ResponseEntity.ok().body(new QuestionResponse(questionRepository.findByInventoryIds(newQuestionIds)));
    }
}
