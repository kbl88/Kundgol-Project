package com.kbl.kundgolservice.repository;

import com.kbl.kundgolservice.dto.ServiceDto;

import java.util.List;

public interface ServiceDtoRepository extends ReadOnlyRepository<ServiceDto, Long>{
        List<ServiceDto> findByPersonId(Long id);
}

