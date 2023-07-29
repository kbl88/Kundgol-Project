
package com.kbl.kundgolservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceDto {
    private Long placeId;
    private String placeCode;
    private String placeName;
    private String placeNameK;
    private List<CategoryDto> categoryDtoList;
}


