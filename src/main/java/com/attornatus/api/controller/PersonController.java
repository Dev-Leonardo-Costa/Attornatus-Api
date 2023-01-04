package com.attornatus.api.controller;

import com.attornatus.domain.exception.BusinessException;
import com.attornatus.domain.exception.PersonNotFoundException;
import com.attornatus.domain.model.Person;
import com.attornatus.domain.repository.PersonRepository;
import com.attornatus.domain.service.RegisterPerson;
import org.springframework.beans.BeanUtils;
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

    @GetMapping
    public List<Person> list() {
        return registerPerson.fetchAllPerson();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@RequestBody Person person) {
        return registerPerson.toSave(person);
    }

    @GetMapping("/{personId}")
    public Person consult(@PathVariable Long personId) {
        return registerPerson.seekOrFailPerson(personId);
    }

    @PutMapping("/{personId}")
    public Person edit(@PathVariable Long personId, @RequestBody Person person) {
        try {
            Person currentPerson = registerPerson.seekOrFailPerson(personId);
            BeanUtils.copyProperties(person, currentPerson, "id");
            return registerPerson.toSave(currentPerson);
        } catch (PersonNotFoundException ex) {
            throw new BusinessException(ex.getMessage());
        }
    }

}