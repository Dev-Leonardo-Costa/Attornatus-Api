package com.attornatus.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;
@ApiModel("Object Person")
@Getter
@Setter
public class PersonDTO {

    private Integer id;
    private String name;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateBirth;

    @JsonFormat(pattern = "dd/MM/yyyy[ HH:mm:ss]")
    private OffsetDateTime dateRegistration;

    @JsonFormat(pattern = "dd/MM/yyyy[ HH:mm:ss]")
    private OffsetDateTime dateRegistrationUpdate;

}