package com.kbl.kundgolservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Immutable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="service_view")
@Immutable
public class ServiceView {
    @Id
    private Long serviceId;
    private String serviceType;//I(individual)/G(General)
    private String messageTitle;
    private String message;
    private String placeCode;
    private String placeName;
    private String placeNamek;
    private String wardCode;
    private String wardName;
    private String wardNamek;
    private Long personId;
    private String personName;
    private String personNamek;
    private String aadhaarNo;
    private String contactNo;
    private String address;
    private String categoryCode;
    private String categoryName;
    private String categoryNamek;
}
