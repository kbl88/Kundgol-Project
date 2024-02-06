package com.kbl.kundgolservice.controller;

import com.kbl.kundgolservice.entity.Category;
//import com.kbl.kundgolservice.entity.PublicService;
import com.kbl.kundgolservice.service.UserInfoService;
import  com.kbl.kundgolservice.service.JwtService;
import com.kbl.kundgolservice.exception.ResourceAlreadyExistExcepton;
import com.kbl.kundgolservice.exception.ResourceNotFoundException;
import com.kbl.kundgolservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService service1;
    @Autowired
    private UserInfoService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/admin/categories")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Category>> fetchCategories() throws ResourceNotFoundException {
        List<Category> categoryList = service1.fetchAllCategory();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);

    }
    @PostMapping ("/admin/category")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) throws ResourceAlreadyExistExcepton {
        Category savedCategory = service1.saveCategory(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.OK);

    }
}
