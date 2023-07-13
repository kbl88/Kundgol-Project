package com.kbl.kundgolservice.controller;

import com.kbl.kundgolservice.entity.Person;
import com.kbl.kundgolservice.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class PersonController {
    @Autowired
    private PersonService personService;

    /*
         http://localhost:8082/person
    {
        "placeCode":"PL-02",
        "wardCode":"WD-03",
        "personName":"XYZ",
        "aadhaarNo":"5678123412345678",
        "contactNo":"9012345678"
    }
     */
    @PostMapping("/person")
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        Person savedPerson = personService.savePerson(person);
        return new ResponseEntity<>(savedPerson, HttpStatus.OK);

    }

    /*
        http://localhost:8082/person/1234567812345678
     */
    @GetMapping("/person/{aadharno}")
    public ResponseEntity<Person> fetchPersonByAadharno(@PathVariable String aadharno) {
        Person person = personService.fetchPersonByAadharno(aadharno);
        if (null != person)
            return new ResponseEntity<>(person, HttpStatus.FOUND);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /*
        http://localhost:8082/person?name=XYZ
        http://localhost:8082/person?name=ಎಬಿಸಿ
     */
    @GetMapping("/person")
    public ResponseEntity<Optional<Person>> fetchPersonByName(@RequestParam String name) {
        Optional<Person> person = personService.fetchPersonByName(name);
        if (person.isPresent())
            return new ResponseEntity<>(person, HttpStatus.FOUND);
        else return new ResponseEntity<>(person, HttpStatus.NOT_FOUND);
    }

}
