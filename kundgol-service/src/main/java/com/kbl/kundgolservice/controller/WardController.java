package com.kbl.kundgolservice.controller;

import com.kbl.kundgolservice.entity.Ward;
import com.kbl.kundgolservice.exception.ResourceAlreadyExistExcepton;
import com.kbl.kundgolservice.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/kundgol")
public class WardController{

    @Autowired
    private WardService wardService;
    @PostMapping("/admin/ward")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Ward> saveWard(@RequestBody Ward ward) throws ResourceAlreadyExistExcepton {
        Ward savedWard = wardService.saveWard(ward);
        if (savedWard.getWardId() !=null){
            return new ResponseEntity<>(savedWard, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/admin/ward")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Ward>> fetchAllWard(){
        List<Ward> wardList = wardService.fetchAllWard();
        if (wardList.size()>0){
            return new ResponseEntity<>(wardList,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
