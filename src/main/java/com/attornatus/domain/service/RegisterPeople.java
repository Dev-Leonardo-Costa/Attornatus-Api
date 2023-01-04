package com.attornatus.domain.service;

import com.attornatus.domain.model.People;
import com.attornatus.domain.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegisterPeople {

    @Autowired
    private PeopleRepository repository;

    @Transactional
    public List<People> fetchAllPeople(){
        return repository.findAll();
    }

    @Transactional
    public People toSave(People people){
        return repository.save(people);
    }

}