package com.attornatus.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Address {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String place;
    private String zipCode;
    private int number;
    private String city;


    @ManyToOne
    @JoinColumn(nullable = false,name = "people_id")
    private People people;

}
