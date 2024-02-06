package com.kbl.kundgolservice.service;

import com.kbl.kundgolservice.entity.Ward;
import com.kbl.kundgolservice.exception.ResourceAlreadyExistExcepton;
import com.kbl.kundgolservice.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WardService {

    @Autowired
    private WardRepository wardRepository;
    public Ward saveWard(Ward ward) throws ResourceAlreadyExistExcepton {
        Ward existingWard = wardRepository.findByPlaceCodeAndWardCode(ward.getPlaceCode(),ward.getWardCode());
        if (null == existingWard) {
            ward.setCreatedBy(1L);
            ward.setCreatedDate(LocalDate.now());
            return wardRepository.save(ward);
        } else {
            throw new ResourceAlreadyExistExcepton("Ward already exist with this PlaceCode :: " + ward.getPlaceCode() +" and wardCode :: "+ward.getWardCode());
        }
    }

    public List<Ward> fetchAllWard(){
        return wardRepository.findAll();
    }
}
