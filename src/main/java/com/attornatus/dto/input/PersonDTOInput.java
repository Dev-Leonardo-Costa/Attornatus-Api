package com.attornatus.dto.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@ApiModel("Person")
@Getter
@Setter
public class PersonDTOInput {

    @ApiModelProperty(example = "Leonardo Costa")
    @NotBlank
    private String name;

    private LocalDate dateBirth;

}
