package com.attornatus.dto.assembler;

import com.attornatus.domain.model.Person;
import com.attornatus.dto.PersonDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonDTOAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public PersonDTO toModel(Person person) {
        return modelMapper.map(person, PersonDTO.class);
    }

    public List<PersonDTO> toCollectionDTO(List<Person> persons) {
        return persons.stream()
                .map(person -> toModel(person))
                .collect(Collectors.toList());
    }

}
