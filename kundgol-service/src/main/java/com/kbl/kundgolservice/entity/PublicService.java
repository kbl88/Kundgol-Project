/*package com.kbl.kundgolservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="public_service")
public class PublicService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;
    private String placeCode;
    private String wardCode;
    private String personName;
    @Lob
    private byte[] imageData;
    private String message;
    private Long createdBy;
    private LocalDate createdDate;
    private Long updatedBy;
    private LocalDate updatedDate;

}
*/
