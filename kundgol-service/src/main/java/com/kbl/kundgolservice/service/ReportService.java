package com.kbl.kundgolservice.service;

import com.kbl.kundgolservice.dto.PersonDto;
import com.kbl.kundgolservice.dto.ServiceDto;
import com.kbl.kundgolservice.repository.PersonDtoRepository;
import com.kbl.kundgolservice.repository.ServiceDtoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ReportService {
    @Autowired
    private PersonDtoRepository personDtoRepository;
    @Autowired
    private ServiceDtoRepository serviceDtoRepository;
    public Optional<PersonDto> fetchPersonById(Long id) {
        Optional<PersonDto> personDto = Optional.ofNullable(personDtoRepository.findByPersonId(id));
        List<ServiceDto> serviceDtoList = serviceDtoRepository.findByPersonId(id);

        return personDto;
    }

}

