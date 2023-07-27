package com.kbl.kundgolservice.repository;

import com.kbl.kundgolservice.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlaceRepository extends JpaRepository<Place,Long> {
    List<Place> findAll();
    Place findByPlaceCode(String code);
}
