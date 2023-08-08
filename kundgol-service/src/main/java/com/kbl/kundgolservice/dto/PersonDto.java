package com.kbl.kundgolservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private Long personId;
    private String personName;
    private String personNameK;
    private String address;
    private String aadhaarNo;
    private String contactNo;
    private List<ServiceDto> services;

}