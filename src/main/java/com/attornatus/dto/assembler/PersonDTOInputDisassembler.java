package com.attornatus.dto.assembler;

import com.attornatus.domain.model.Person;
import com.attornatus.dto.input.PersonDTOInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonDTOInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;
    public Person toDomainObject(PersonDTOInput personDTOInput) {
       return modelMapper.map(personDTOInput, Person.class);
    }

    public void copyToDomainObject(PersonDTOInput personDTOInput, Person person){
        modelMapper.map(personDTOInput, person);
    }

}
