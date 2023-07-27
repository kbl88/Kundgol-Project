package com.kbl.kundgolservice.repository;

import com.kbl.kundgolservice.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WardRepository extends JpaRepository<Ward,Long> {
    Ward findByPlaceCodeAndWardCode(String placeCode,String wardCode);
}
