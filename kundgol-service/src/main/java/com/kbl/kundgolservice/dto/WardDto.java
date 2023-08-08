
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
public class WardDto {
    private Long wardId;
    private String wardCode;
    private String wardName;
    private String wardNameK;
    private List<ServiceDto> services;
}


