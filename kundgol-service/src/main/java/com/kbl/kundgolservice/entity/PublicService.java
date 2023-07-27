package com.kbl.kundgolservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="public_service")
public class PublicService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;
    private Long personId;
    private String categoryCode;
    private String serviceType;//I(individual)/G(General)
    private String personName;
    private String personNameK;
    private String placeCode;
    private String wardCode;
    private String year;
    @Lob
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
