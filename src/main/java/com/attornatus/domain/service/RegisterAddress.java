package com.attornatus.domain.service;

import com.attornatus.domain.exception.AddressNotFoundException;
import com.attornatus.domain.model.Address;
import com.attornatus.domain.model.Person;
import com.attornatus.domain.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegisterAddress {

    @Autowired
    private AddressRepository repository;

    @Transactional
    public Address toSave(Address address, Integer personId, Person person) {
        address.setPerson(person);
        repository.save(address);

        if (address.getAddressMain().equals(true)) {
            mainAddress(address.getId(), personId, person);
        }

        return repository.save(address);
    }


    @Transactional
    public void mainAddress(Integer addressId, Integer personId, Person person) {
        Address addressCurrent = seekOrFailAddress(addressId, personId);
        List<Address> addresses = repository.findByPerson(person);

        Address addressMainOld = addresses.stream()
                .filter(address -> address.getAddressMain() && address.getId() != addressId)
                .findFirst()
                .orElse(null);

        if (addressMainOld != null) {
            addressMainOld.setAddressMain(false);
            repository.save(addressMainOld);
        }

        addressCurrent.setAddressMain(true);

        repository.save(addressCurrent);
    }

    public Address seekOrFailAddress(Integer addressId, Integer personId) {
        return repository.findById(addressId)
                .orElseThrow(() -> new AddressNotFoundException(addressId, personId));
    }

}