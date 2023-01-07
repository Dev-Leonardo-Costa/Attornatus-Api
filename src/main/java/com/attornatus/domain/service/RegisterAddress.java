package com.attornatus.domain.service;

import com.attornatus.domain.model.Address;
import com.attornatus.domain.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterAddress {

    @Autowired
    private AddressRepository repository;


    @Transactional
    public Address toSave(Address address){
        return repository.save(address);
    }

}