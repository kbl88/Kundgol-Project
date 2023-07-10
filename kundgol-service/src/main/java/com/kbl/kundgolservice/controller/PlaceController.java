package com.kbl.kundgolservice.controller;

import com.kbl.kundgolservice.entity.Place;
import com.kbl.kundgolservice.service.PlaceService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class PlaceController {
    @Autowired
    private PlaceService service;
    @GetMapping("/places")
    public ResponseEntity<List<Place>> fetchAllPlaces(){
        List<Place> placeList = service.fetchAllPlaces();
        return new ResponseEntity<>(placeList,HttpStatus.OK);
    }
}
