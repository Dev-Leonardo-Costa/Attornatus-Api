package com.attornatus.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
public class AddressDTOInput {

    @NotBlank
    private String publicPlace;

    @NotBlank
    private String zipCode;

    @PositiveOrZero
    private int number;

    @NotBlank
    private String city;

    private Boolean addressMain;

}
