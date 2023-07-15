package com.kbl.kundgolservice.controller;

import com.kbl.kundgolservice.entity.Person;
import com.kbl.kundgolservice.entity.PublicService;
import com.kbl.kundgolservice.service.PublicServiceService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class PublicServiceController {
    @Autowired
    private PublicServiceService service;

    @PostMapping("/service")
    public ResponseEntity<PublicService> savePublicService(@RequestBody PublicService publicService) {
        PublicService publicService1 = service.savePublicService(publicService);
        return new ResponseEntity<>(publicService1, HttpStatus.OK);

    }
    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/uploadfile")
    public void savePublicService(@RequestParam("image") MultipartFile file,@RequestParam("id") Long serviceId) throws IOException{
       service.uploadImage(file,serviceId);
    }
    @GetMapping("/service/{name}")
    public ResponseEntity<Optional<PublicService>> fetchPublicServiceByName(@PathVariable String name){
        Optional<PublicService> publicService = service.fetchPublicServiceByName(name);
        if (publicService.isPresent())
            return new ResponseEntity<>(publicService, HttpStatus.FOUND);
        else return new ResponseEntity<>(publicService, HttpStatus.NOT_FOUND);
    }
    /*@GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable Long id) {
        byte[] image = service.downloadImage(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/jpg")).body(image);
    }*/

}


