package com.kbl.kundgolservice.service;

import com.kbl.kundgolservice.entity.Person;
import com.kbl.kundgolservice.exception.ResourceAlreadyExistExcepton;
import com.kbl.kundgolservice.exception.ResourceNotFoundException;
import com.kbl.kundgolservice.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public Person savePerson(Person person) throws ResourceAlreadyExistExcepton {
        Person existPerson = repository.findByAadhaarNo(person.getAadhaarNo());
        if(null == existPerson){
            person.setCreatedBy(1L);
            person.setCreatedDate(LocalDate.now());
            return repository.save(person);
        }
        else {
            throw new ResourceAlreadyExistExcepton("Person already exist with this AadharNo :: " + person.getAadhaarNo());
        }
       /* person.setCreatedBy(1L);
        person.setCreatedDate(LocalDate.now());
        return repository.save(person);*/
    }

    public Person fetchPersonByAadharno(String aadharno) throws ResourceNotFoundException{
        Person person = repository.findByAadhaarNo(aadharno);
        if(null == person){
            throw new ResourceNotFoundException("ResourceNotFoundException with aadharno :: "+aadharno);
        }else {
            return person;
        }
    }

    public Optional<Person> fetchPersonByName(String name){
        return Optional.ofNullable(repository.findByPersonName(name));
       /* if(p.isPresent())
            return p;
        else{
            p =  Optional.ofNullable(repository.findByPersonNameK(name));
                return p;
        }*/
    }

    public List<Person> fetchAllPerson() throws ResourceNotFoundException {
        List<Person> personList = repository.findAll();
        if(personList.isEmpty())
        {
            throw new ResourceNotFoundException("ResourceNotFoundException");
        }else {
            return repository.findAll();
        }
    }
}
