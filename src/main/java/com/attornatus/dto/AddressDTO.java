package com.attornatus.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private Long id;

    private String publicPlace;

    private String zipCode;

    private int number;

    private String city;

    private Boolean addressMain;
}
