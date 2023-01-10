package com.attornatus.api.controller.openapi;

import com.attornatus.api.exceptionhandler.Problem;
import com.attornatus.dto.AddressDTO;
import com.attornatus.dto.input.AddressDTOInput;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Api(tags = "Addresses")
public interface AddressOpenApi {

    @ApiOperation("Lista os endereços de uma pessoa através do ID")
    public List<AddressDTO> listPersonAddress(@ApiParam("ID de uma pessoa") Integer personId);


    @ApiOperation("Cadastra um endereço através do ID da pessoa")
    @ApiResponses({@ApiResponse(code = 404, message = "Pessoa não encontrada", response = Problem.class)})
    public AddressDTO create(@ApiParam("ID de uma pessoa") @PathVariable Integer personId, AddressDTOInput addressDTOInput);

    @ApiOperation("Faz escolha do endereço principal através ID da Pessoa e o ID do Endereço")
    public void addressMain(@ApiParam("ID da pessoa") Integer personId, @ApiParam("ID do endereço") Integer addressId);
}