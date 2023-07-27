package com.kbl.kundgolservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor

public class PublicServiceDto {
    private Long serviceId;
    private String categoryCode;
    private String categoryName;
    private String categoryNameK;
    private String serviceType;
    private String personName;
    private String personNameK;
    private String placeCode;
    private String placeName;
    private String placeNameK;
    private String wardCode;
    private String wardName;
    private String wardNameK;
    private String year;
    private byte[] imageData;
    private String fileName;
    private String fileType;
    private String messageTitle;
    private String message;
    private Long createdBy;
    private LocalDate createdDate;
    private Long updatedBy;
    private LocalDate updatedDate;
}
