package com.kbl.kundgolservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "place")
@NoArgsConstructor
@AllArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placeId;
    private String placeCode;
    private String placeName;
    private String placeNameK;
    private Long createdBy;
    private LocalDate createdDate;
    private Long updatedBy;
    private LocalDate updatedDate;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "placeCode", referencedColumnName = "placeCode")
    List< Ward > wards = new ArrayList<>();
}
