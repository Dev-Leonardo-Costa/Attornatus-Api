package com.attornatus.dto.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@ApiModel("Address")
@Getter
@Setter
public class AddressDTOInput {

    @ApiModelProperty(example = "Rua Padre roma")
    @NotBlank
    private String publicPlace;

    @ApiModelProperty(example = "12345-030")
    @NotBlank
    private String zipCode;

    @ApiModelProperty(example = "1234")
    @PositiveOrZero
    private int number;

    @ApiModelProperty(example = "Florianópolis")
    @NotBlank
    private String city;

    private Boolean addressMain;

}
