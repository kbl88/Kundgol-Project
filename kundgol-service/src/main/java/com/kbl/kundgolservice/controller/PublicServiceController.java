package com.kbl.kundgolservice.controller;

import com.kbl.kundgolservice.dto.PersonDto;
import com.kbl.kundgolservice.entity.Person;
import com.kbl.kundgolservice.entity.PublicService;
import com.kbl.kundgolservice.service.PublicServiceService;
import com.kbl.kundgolservice.service.ReportService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private ReportService reportService;
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
    @GetMapping("/service/{personName}")
    public ResponseEntity<Optional<PublicService>> fetchPublicServiceByName(@PathVariable String personName){
        Optional<PublicService> publicService = service.fetchPublicServiceByName(personName);
        if (publicService.isPresent())
            return new ResponseEntity<>(publicService, HttpStatus.FOUND);
        else return new ResponseEntity<>(publicService, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/report/{personName}")
    public List<PublicService> fetchPublicServiceReportByPersonName(@PathVariable String personName){
        List<PublicService> publicServiceList = service.getPersonWiseData(personName);
        return publicServiceList;
    }
    @GetMapping("/report/{placeCode}/{wardCode}")
    public List<PublicService> fetchPublicServiceReportByPlaceCode(@PathVariable String placeCode,@PathVariable String wardCode){
        List<PublicService> publicServiceList = service.fetchByPlaceCodeAndWardCodeAndServiceType(placeCode,wardCode,"G");
        return publicServiceList;
    }
    @GetMapping("/personwisereport/{id}")
    public ResponseEntity<Optional<PersonDto>> fetchByPersonId(@PathVariable Long id){
        Optional<PersonDto> personDto = reportService.fetchPersonById(id);
        if (personDto.isPresent())
            return new ResponseEntity<>(personDto, HttpStatus.FOUND);
        else return new ResponseEntity<>(personDto, HttpStatus.NOT_FOUND);
    }
}


