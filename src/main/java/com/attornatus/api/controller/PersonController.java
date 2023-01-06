package com.attornatus.api.controller;

import com.attornatus.domain.model.Person;
import com.attornatus.domain.repository.PersonRepository;
import com.attornatus.domain.service.RegisterPerson;
import com.attornatus.dto.PersonDTO;
import com.attornatus.dto.assembler.PersonDTOAssembler;
import com.attornatus.dto.assembler.PersonDTOInputDisassembler;
import com.attornatus.dto.input.PersonDTOInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private RegisterPerson registerPerson;

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonDTOAssembler assemblerDTO;

    @Autowired
    private PersonDTOInputDisassembler personDTOInputDisassembler;

    @GetMapping
    public List<PersonDTO> list() {
        return assemblerDTO.toCollectionDTO(registerPerson.fetchAllPerson());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO create(@RequestBody PersonDTOInput personInput) {
        Person person = personDTOInputDisassembler.toDomainObject(personInput);
        return assemblerDTO.toModel(registerPerson.toSave(person));
    }

    @GetMapping("/{personId}")
    public PersonDTO consult(@PathVariable Long personId) {
        Person person = registerPerson.seekOrFailPerson(personId);
        return assemblerDTO.toModel(person);
    }

    @PutMapping("/{personId}")
    public PersonDTO edit(@PathVariable Long personId, @RequestBody PersonDTOInput personInput) {
//        Person person = disassemblerDTO.toDomainObject(personInput);
        Person currentPerson = registerPerson.seekOrFailPerson(personId);
        personDTOInputDisassembler.copyToDomainObject(personInput, currentPerson);
//        BeanUtils.copyProperties(person, currentPerson, "id");
        return assemblerDTO.toModel(registerPerson.toSave(currentPerson));
    }

}