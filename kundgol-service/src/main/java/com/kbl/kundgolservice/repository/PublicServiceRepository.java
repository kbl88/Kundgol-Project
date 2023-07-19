package com.kbl.kundgolservice.repository;

import com.kbl.kundgolservice.entity.Person;
import com.kbl.kundgolservice.entity.PublicService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Repository
public interface PublicServiceRepository extends JpaRepository<PublicService, Long> {
    List<PublicService> findAll();
    PublicService findByPersonName(String personName);
    PublicService findByPersonNameK(String personName);
    List<PublicService> findByPlaceCodeAndWardCodeAndServiceType(String placeCode,String wardCode,String type);
    //f(placeCode,wardCode,serviceTyp
    List<PublicService> findByWardCodeAndServiceType(String wardCode,String type);
    //List<PublicService> findByCreatedDateAndServiceType(LocalDate date,String type);
    Optional<PublicService> findByServiceId(Long id);

    //List<PublicService> findByPersonName(String personName);

    /*
        --select * FROM `public_service` WHERE person_name="Vishwa Basavaraj Tadsur";

SELECT * FROM `public_service` WHERE `ward_code` = (SELECT `ward_code` FROM `public_service`
WHERE person_name="Vishwa Basavaraj Tadsur") AND `service_type`="G";

SELECT * FROM `public_service` WHERE `place_code` = (SELECT `place_code` FROM `public_service`
WHERE person_name="Vishwa Basavaraj Tadsur") AND `ward_code` = "WD-ALL" AND `service_type`="G";
         */

}
