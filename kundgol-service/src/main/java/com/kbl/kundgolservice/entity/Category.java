package com.kbl.kundgolservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryCode;
    private String categoryName;
    private String categoryNameK;
    private Long createdBy;
    private LocalDate createdDate;
    private Long updatedBy;
    private LocalDate updatedDate;

}
