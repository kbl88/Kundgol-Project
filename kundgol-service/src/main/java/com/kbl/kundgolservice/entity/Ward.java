package com.kbl.kundgolservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name ="ward")
@AllArgsConstructor
@NoArgsConstructor

public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wardId;
    private String wardCode;
    private String placeCode;
    private String wardName;
    private String wardNameK;
    private Long createdBy;
    private LocalDate createdDate;
    private Long updatedBy;
    private LocalDate updatedDate;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumns({@JoinColumn(name = "placeCode", referencedColumnName = "placeCode"),
            @JoinColumn(name = "wardCode", referencedColumnName = "wardCode")})
    private List<Person> personList;
}
