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

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private RegisterPerson registerPerson;

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonDTOAssembler personDTOAssembler;

    @Autowired
    private PersonDTOInputDisassembler personDTOInputDisassembler;

    @GetMapping
    public List<PersonDTO> list() {
        return personDTOAssembler.toCollectionDTO(registerPerson.fetchAllPerson());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO create(@RequestBody @Valid PersonDTOInput personInput) {
        Person person = personDTOInputDisassembler.toDomainObject(personInput);
        return personDTOAssembler.toModel(registerPerson.toSave(person));
    }

    @GetMapping("/{personId}")
    public PersonDTO consult(@PathVariable Long personId) {
        Person person = registerPerson.seekOrFailPerson(personId);
        System.out.println(person);
        return personDTOAssembler.toModel(person);
    }

    @PutMapping("/{personId}")
    public PersonDTO edit(@PathVariable Long personId, @RequestBody @Valid  PersonDTOInput personInput) {
        Person currentPerson = registerPerson.seekOrFailPerson(personId);
        personDTOInputDisassembler.copyToDomainObject(personInput, currentPerson);
        return personDTOAssembler.toModel(registerPerson.toSave(currentPerson));
    }

}