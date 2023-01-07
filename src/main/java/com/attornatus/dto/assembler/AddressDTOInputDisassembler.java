package com.attornatus.dto.assembler;

import com.attornatus.domain.model.Address;
import com.attornatus.dto.input.AddressDTOInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressDTOInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Address toDomainObject(AddressDTOInput addressDTOInput) {
        return modelMapper.map(addressDTOInput, Address.class);
    }

}