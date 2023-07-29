package com.kbl.kundgolservice.service;

import com.kbl.kundgolservice.entity.Person;
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

    public Person savePerson(Person person){
       // person.setCreatedBy(1L);
       // person.setCreatedDate(LocalDate.now());
        return repository.save(person);
    }

    public Person fetchPersonByAadharno(String aadharno){
        return repository.findByAadhaarNo(aadharno);

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

    public List<Person> fetchAllPerson(){
        return repository.findAll();
    }
}
