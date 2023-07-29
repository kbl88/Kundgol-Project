package com.kbl.kundgolservice.controller;

import com.kbl.kundgolservice.entity.Person;
import com.kbl.kundgolservice.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@AllArgsConstructor
@NoArgsConstructor
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        Person savedPerson = personService.savePerson(person);
        return new ResponseEntity<>(savedPerson, HttpStatus.OK);
    }
    @GetMapping("/persons")
    public ResponseEntity<List<Person>> fetchAllPerson(){
        List<Person> personList = personService.fetchAllPerson();
        if(personList.size()>0){
            return new ResponseEntity<>(personList,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/person/{aadharno}")
    public ResponseEntity<Person> fetchPersonByAadharno(@PathVariable String aadharno) {
        Person person = personService.fetchPersonByAadharno(aadharno);
        if (null != person)
            return new ResponseEntity<>(person, HttpStatus.FOUND);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/person")
    public ResponseEntity<Optional<Person>> fetchPersonByName(@RequestParam String name) {
        Optional<Person> person = personService.fetchPersonByName(name);
        if (person.isPresent())
            return new ResponseEntity<>(person, HttpStatus.FOUND);
        else return new ResponseEntity<>(person, HttpStatus.NOT_FOUND);
    }

}
