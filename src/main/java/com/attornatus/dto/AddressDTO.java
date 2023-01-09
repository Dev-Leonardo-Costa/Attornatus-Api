package com.attornatus.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel("Object Address")
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
