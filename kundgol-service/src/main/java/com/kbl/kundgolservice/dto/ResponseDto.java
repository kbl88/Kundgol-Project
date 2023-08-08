
package com.kbl.kundgolservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private PersonDto person;
    private WardDto ward;
    private PlaceDto place;
    private TalukDto taluk;
}


