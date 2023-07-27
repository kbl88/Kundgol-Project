package com.kbl.kundgolservice.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "service_dto")
@Immutable
public class ServiceDto {
    @Id
    private Long serviceId;
    private Long personId;
    private String wardCode;
    private String placeCode;
    private String serviceType;
    private String year;
    private String messageTitle;
    private String message;
}
