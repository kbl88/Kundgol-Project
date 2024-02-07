package com.kbl.kundgolservice.controller;

import com.kbl.kundgolservice.dto.PersonDto;
import com.kbl.kundgolservice.entity.Person;
import com.kbl.kundgolservice.entity.PublicService;
import com.kbl.kundgolservice.entity.ServiceView;
import com.kbl.kundgolservice.service.PublicServiceService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@RestController
@AllArgsConstructor
@NoArgsConstructor
public class PublicServiceController {
    @Autowired
    private PublicServiceService service;

    @PostMapping("/kundgol/service")
    public ResponseEntity<PublicService> savePublicService(@RequestBody PublicService publicService) {
        PublicService publicService1 = service.savePublicService(publicService);
        return new ResponseEntity<>(publicService1, HttpStatus.OK);

    }
    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/kundgol/uploadfile")
    public void savePublicService(@RequestParam("image") MultipartFile file,@RequestParam("id") Long serviceId) throws IOException{
       service.uploadImage(file,serviceId);
    }

    @GetMapping("/kundgol/service")
    public ResponseEntity<List<ServiceView>> fetchAllService(){
        List<ServiceView> serviceViewList = service.fetchAllService();
        if (serviceViewList.size()>0){
            return new ResponseEntity<>(serviceViewList,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

}


