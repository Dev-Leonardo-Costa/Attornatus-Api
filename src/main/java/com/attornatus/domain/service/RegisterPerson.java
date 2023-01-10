package com.attornatus.domain.service;

import com.attornatus.domain.exception.PersonNotFoundException;
import com.attornatus.domain.model.Person;
import com.attornatus.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegisterPerson {

    @Autowired
    private PersonRepository repository;


    @Transactional
    public List<Person> fetchAllPerson() {
        return repository.findAll();
    }


    @Transactional
    public Person toSave(Person person) {
        return repository.save(person);
    }

    public Person seekOrFailPerson(Integer personId) {
        return repository.findById(personId)
                .orElseThrow(() -> new PersonNotFoundException(personId));
    }

}