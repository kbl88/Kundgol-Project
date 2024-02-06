package com.kbl.kundgolservice.service;


import com.kbl.kundgolservice.entity.Category;
import com.kbl.kundgolservice.entity.Place;
import com.kbl.kundgolservice.exception.ResourceAlreadyExistExcepton;
import com.kbl.kundgolservice.exception.ResourceNotFoundException;
import com.kbl.kundgolservice.repository.CategoryRepository;
import com.kbl.kundgolservice.repository.PlaceRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    public List<Category> fetchAllCategory() throws ResourceNotFoundException {
        List<Category> categoryList;
        try{
            return categoryList = repository.findAll();
        }
        catch(Exception e){
            throw new ResourceNotFoundException("No Resources are found");
        }
        /*List<Category> categoryList = repository.findAll();
        return categoryList;*/
    }
    public Category saveCategory(Category category) throws ResourceAlreadyExistExcepton {
        Category existCategory = repository.findByCategoryCode(category.getCategoryCode());
        if(null == existCategory){
            category.setCreatedBy(1L);
            category.setCreatedDate(LocalDate.now());
            return repository.save(category);
        }else {
            throw new ResourceAlreadyExistExcepton("Place already exist with this PlaceCode :: " + category.getCategoryCode());
        }/*{
        Category savedCategory = repository.save(category);
        return savedCategory;*/
    }
}
