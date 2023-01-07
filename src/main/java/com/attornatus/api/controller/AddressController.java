package com.attornatus.api.controller;

import com.attornatus.domain.model.Address;
import com.attornatus.domain.model.Person;
import com.attornatus.domain.repository.AddressRepository;
import com.attornatus.domain.service.RegisterPerson;
import com.attornatus.dto.AddressDTO;
import com.attornatus.dto.assembler.AddressDTOAssembler;
import com.attornatus.dto.assembler.AddressDTOInputDisassembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons/{personId}/addresses")
public class AddressController {

    @Autowired
    private AddressDTOAssembler addressDTOAssembler;

    @Autowired
    private AddressDTOInputDisassembler addressDTOInputDisassembler;

    @Autowired
    private RegisterPerson registerPerson;

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public List<AddressDTO> listPersonAddress(@PathVariable Long personId) {
        Person person = registerPerson.seekOrFailPerson(personId);
        List<Address> AllAddresses = addressRepository.findByPerson(person);
        return addressDTOAssembler.toCollectionDTO(AllAddresses);
    }
}