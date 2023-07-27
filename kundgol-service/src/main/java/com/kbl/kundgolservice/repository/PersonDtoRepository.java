package com.kbl.kundgolservice.repository;

import com.kbl.kundgolservice.dto.PersonDto;

public interface PersonDtoRepository extends ReadOnlyRepository<PersonDto, Long>{
    PersonDto findByPersonId(Long id);
}
