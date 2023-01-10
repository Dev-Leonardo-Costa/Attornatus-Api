package com.attornatus.api.controller;

import com.attornatus.api.controller.openapi.AddressOpenApi;
import com.attornatus.domain.model.Address;
import com.attornatus.domain.model.Person;
import com.attornatus.domain.repository.AddressRepository;
import com.attornatus.domain.service.RegisterAddress;
import com.attornatus.domain.service.RegisterPerson;
import com.attornatus.dto.AddressDTO;
import com.attornatus.dto.assembler.AddressDTOAssembler;
import com.attornatus.dto.assembler.AddressDTOInputDisassembler;
import com.attornatus.dto.input.AddressDTOInput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Addresses")
@RestController
@RequestMapping(path = "/persons/{personId}/addresses", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressController implements AddressOpenApi {

    @Autowired
    private AddressDTOAssembler addressDTOAssembler;

    @Autowired
    private AddressDTOInputDisassembler addressDTOInputDisassembler;

    @Autowired
    private RegisterPerson registerPerson;

    @Autowired
    private RegisterAddress registerAddress;
    @Autowired
    private AddressRepository addressRepository;
    @GetMapping
    public List<AddressDTO> listPersonAddress(@ApiParam("ID da pessoa") @PathVariable Integer personId) {
        Person person = registerPerson.seekOrFailPerson(personId);
        List<Address> AllAddresses = addressRepository.findByPerson(person);
        return addressDTOAssembler.toCollectionDTO(AllAddresses);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDTO create(@PathVariable Integer personId, @RequestBody @Valid AddressDTOInput addressDTOInput){
        Person person = registerPerson.seekOrFailPerson(personId);
        Address address = addressDTOInputDisassembler.toDomainObject(addressDTOInput);
        address = registerAddress.toSave(address,personId, person);
        return  addressDTOAssembler.toModel(address);
    }

    @PutMapping("/address-main/{addressId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addressMain(@PathVariable Integer personId, @PathVariable Integer addressId){
        Person person = registerPerson.seekOrFailPerson(personId);
        registerAddress.mainAddress(addressId,personId, person);
    }

}