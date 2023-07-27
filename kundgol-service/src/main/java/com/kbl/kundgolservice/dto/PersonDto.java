package com.kbl.kundgolservice.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "person_dto")
@Immutable
public class PersonDto {
    @Id
    private Long personId;
    private String personName;
    private String personNameK;
    private String address;
    private String aadhaarNo;
    private String contactNo;
    //List<ServiceDto> serviceDtoList = new ArrayList<>();

}