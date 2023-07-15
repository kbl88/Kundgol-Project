package com.kbl.kundgolservice.service;


import com.kbl.kundgolservice.entity.Category;
import com.kbl.kundgolservice.entity.Place;
import com.kbl.kundgolservice.repository.CategoryRepository;
import com.kbl.kundgolservice.repository.PlaceRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    public List<Category> fetchAllCategory(){
        List<Category> categoryList = repository.findAll();
        return categoryList;
    }
}
