package com.attornatus.api.controller.openapi;

import com.attornatus.api.exceptionhandler.Problem;
import com.attornatus.dto.PersonDTO;
import com.attornatus.dto.input.PersonDTOInput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@Api(tags = "Persons")
public interface PersonOpenApi {

    @ApiOperation("Lista as pessoas")
    public List<PersonDTO> list();

    @ApiOperation("Cadastra uma pessoa")
    public PersonDTO create(PersonDTOInput personInput);

    @ApiOperation("Busca uma pessoa por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "404", description = "Pessoa não encontrada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))),
            @ApiResponse(responseCode = "400", description = "ID da pessoa é inválido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class)))
    })

    public PersonDTO consult(@ApiParam("ID de uma pessoa")  Integer personId);

    @ApiOperation("Atualiza uma pessoa por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "404", description = "Pessoa não encontrada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))),
            @ApiResponse(responseCode = "400", description = "ID da pessoa é inválido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class)))
    })

    public PersonDTO edit(@ApiParam("ID de uma pessoa") Integer personId, PersonDTOInput personInput);

}