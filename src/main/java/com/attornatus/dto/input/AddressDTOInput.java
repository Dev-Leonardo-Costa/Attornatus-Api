package com.attornatus.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTOInput {

    private String place;
    private String zipCode;
    private int number;
    private String city;
    private Boolean addressMain;

}
