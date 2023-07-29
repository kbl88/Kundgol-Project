package com.kbl.kundgolservice.controller;

import com.kbl.kundgolservice.entity.Ward;
import com.kbl.kundgolservice.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WardController{

    @Autowired
    private WardService wardService;
    @PostMapping("/ward")
    public ResponseEntity<Ward> saveWard(@RequestBody Ward ward){
        Ward savedWard = wardService.saveWard(ward);
        if (savedWard.getWardId() !=null){
            return new ResponseEntity<>(savedWard, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/ward")
    public ResponseEntity<List<Ward>> fetchAllWard(){
        List<Ward> wardList = wardService.fetchAllWard();
        if (wardList.size()>0){
            return new ResponseEntity<>(wardList,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
