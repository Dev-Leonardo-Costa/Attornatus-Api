package com.attornatus.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
public class PersonDTOInput {

    @NotBlank
    private String name;

    private LocalDate dateBirth;

}
