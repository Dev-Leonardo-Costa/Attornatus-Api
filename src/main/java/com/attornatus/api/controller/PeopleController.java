package com.attornatus.api.controller;

import com.attornatus.domain.model.People;
import com.attornatus.domain.service.RegisterPeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peoples")
public class PeopleController {

    @Autowired
    private RegisterPeople registerPeople;

    @GetMapping
    public List<People> list(){
        return  registerPeople.fetchAllPeople();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public People add(@RequestBody People people){
        return registerPeople.toSave(people);
    }

}