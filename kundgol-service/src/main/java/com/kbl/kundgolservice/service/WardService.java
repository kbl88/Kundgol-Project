package com.kbl.kundgolservice.service;

import com.kbl.kundgolservice.entity.Ward;
import com.kbl.kundgolservice.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardService {

    @Autowired
    private WardRepository wardRepository;
    public Ward saveWard(Ward ward){
        return wardRepository.save(ward);
    }

    public List<Ward> fetchAllWard(){
        return wardRepository.findAll();
    }
}
