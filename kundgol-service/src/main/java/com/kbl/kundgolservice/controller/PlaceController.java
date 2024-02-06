package com.kbl.kundgolservice.controller;

import com.kbl.kundgolservice.entity.Place;
import com.kbl.kundgolservice.exception.ResourceAlreadyExistExcepton;
import com.kbl.kundgolservice.service.PlaceService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
//@RequestMapping("/kundgol")
public class PlaceController {
    @Autowired
    private PlaceService service;
    @GetMapping("/admin/places")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Place>> fetchAllPlaces(){
        List<Place> placeList = service.fetchAllPlaces();
        return new ResponseEntity<>(placeList,HttpStatus.OK);
    }

    @PostMapping("/admin/Place")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Place> savePlace(@RequestBody Place place) throws ResourceAlreadyExistExcepton {
        Place savedPlace = service.savePlace(place);
        if(savedPlace.getPlaceId() !=null){
            return new ResponseEntity<>(savedPlace,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
