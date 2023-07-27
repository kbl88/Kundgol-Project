package com.kbl.kundgolservice.repository;

import com.kbl.kundgolservice.entity.Category;
import com.kbl.kundgolservice.entity.Person;
import com.kbl.kundgolservice.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    List<Category> findAll();
    Category findByCategoryCode(String code);
    /*Category findByCategoryName(String categoryName);
    Category findByCategoryNameK(String categoryNamek);*/
}
