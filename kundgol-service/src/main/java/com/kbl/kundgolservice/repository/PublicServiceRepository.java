package com.kbl.kundgolservice.repository;

import com.kbl.kundgolservice.entity.PublicService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PublicServiceRepository extends JpaRepository<PublicService, Long> {
    List<PublicService> findAll();
    PublicService findByPersonName(String personName);
    PublicService findByPersonNameK(String personName);
    List<PublicService> findByPlaceCodeAndWardCodeAndServiceType(String placeCode,String wardCode,String type);
    List<PublicService> findByWardCodeAndServiceType(String wardCode,String type);
    Optional<PublicService> findByServiceId(Long id);
}
