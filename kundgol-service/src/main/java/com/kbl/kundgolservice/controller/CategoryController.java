package com.kbl.kundgolservice.controller;

import com.kbl.kundgolservice.entity.Category;
import com.kbl.kundgolservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> fetchCategories(){
        List<Category> categoryList = service.fetchAllCategory();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);

    }
}
