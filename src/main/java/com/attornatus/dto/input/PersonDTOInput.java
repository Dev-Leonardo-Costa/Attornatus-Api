package com.attornatus.dto.input;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PersonDTOInput {

    private String name;
    private LocalDate dateBirth;

}
