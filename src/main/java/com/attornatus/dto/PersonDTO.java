package com.attornatus.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Getter
@Setter
public class PersonDTO {

    private Long id;
    private String name;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateBirth;

    @JsonFormat(pattern = "dd/MM/yyyy[ HH:mm:ss]")
    private OffsetDateTime dateRegistration;

    @JsonFormat(pattern = "dd/MM/yyyy[ HH:mm:ss]")
    private OffsetDateTime dateRegistrationUpdate;

}