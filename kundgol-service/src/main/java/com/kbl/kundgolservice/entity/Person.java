package com.kbl.kundgolservice.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;
    private String placeCode;
    private String wardCode;
    private String personName;
    private String personNameK;
    private String aadhaarNo;
    private String contactNo;
    private Long createdBy;
    private LocalDate createdDate;
    private Long updatedBy;
    private LocalDate updatedDate;

}
