package com.attornatus.domain.repository;

import com.attornatus.domain.model.Address;
import com.attornatus.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByPerson(Person person);

}
