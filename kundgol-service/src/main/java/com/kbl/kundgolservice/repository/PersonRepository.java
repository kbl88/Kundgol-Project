package com.kbl.kundgolservice.repository;

import com.kbl.kundgolservice.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

    Person findByAadhaarNo(String aadhaarNo);
    Person findByPersonName(String personName);
    Person findByPersonNameK(String personName);
}
