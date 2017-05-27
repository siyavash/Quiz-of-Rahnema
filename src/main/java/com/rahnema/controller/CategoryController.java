package com.rahnema.controller;

import com.rahnema.exception.CategoryExistsException;
import com.rahnema.model.entity.Category;
import com.rahnema.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by siyavash on 5/27/2017.
 */

@Controller
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity addCategory(@RequestHeader String newCategory) throws CategoryExistsException {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();

        if(! username.equals("admin")) {
            return ResponseEntity.badRequest().body(null);
        }

        Category category = categoryRepository.findByName(newCategory);

        if(category != null) {
            throw new CategoryExistsException(newCategory);
        }

        category.setName(newCategory);

        categoryRepository.save(category);

        return ResponseEntity.ok().body(null);
    }
}
