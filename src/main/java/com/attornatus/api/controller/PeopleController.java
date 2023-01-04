package com.attornatus.api.controller;

import com.attornatus.domain.model.People;
import com.attornatus.domain.service.RegisterPeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/peoples")
public class PeopleController {

    @Autowired
    private RegisterPeople registerPeople;

    @GetMapping
    public List<People> list(){
        return  registerPeople.buscarTodos();
    }

}