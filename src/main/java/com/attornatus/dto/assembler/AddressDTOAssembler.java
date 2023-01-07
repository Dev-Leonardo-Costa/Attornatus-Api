package com.attornatus.dto.assembler;

import com.attornatus.domain.model.Address;
import com.attornatus.dto.AddressDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressDTOAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public AddressDTO toModel(Address address) {
        return modelMapper.map(address, AddressDTO.class);
    }

    public List<AddressDTO> toCollectionDTO(List<Address> addresses) {
        return addresses.stream()
                .map(address -> toModel(address))
                .collect(Collectors.toList());
    }

}
