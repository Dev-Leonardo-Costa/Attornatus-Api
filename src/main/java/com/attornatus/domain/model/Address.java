package com.attornatus.domain.model;


import lombok.*;

import javax.persistence.*;
import java.util.Optional;

@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Address {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String publicPlace;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private int number;

    @Column(nullable = false)
    private String city;

    private Boolean addressMain;

    @ManyToOne
    @JoinColumn(nullable = false, name = "person_id")
    private Person person;

    public Address(Integer id, String publicPlace, String zipCode, int number, String city, Boolean addressMain, Person person) {
        this.id = id;
        this.publicPlace = publicPlace;
        this.zipCode = zipCode;
        this.number = number;
        this.city = city;
        this.addressMain = addressMain;
        this.person = person;
    }
}


