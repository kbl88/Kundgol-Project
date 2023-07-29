package com.kbl.kundgolservice.service;

import com.kbl.kundgolservice.entity.Place;
import com.kbl.kundgolservice.repository.PlaceRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PlaceService {
    @Autowired
    private PlaceRepository repository;
    public List<Place> fetchAllPlaces(){
        List<Place> placeList = repository.findAll();
        return placeList;
    }

    public Place savePlace(Place place){
        return repository.save(place);
    }
}
