package com.rahnema.controller;

import com.rahnema.repository.MatchDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by siyavash on 5/5/2017.
 */

@Controller
@RequestMapping(path = "/match")
public class MatchController {

    @Autowired
    MatchDetailRepository matchDetailRepository;
}
