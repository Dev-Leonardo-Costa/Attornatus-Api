package com.attornatus.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Address {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String place;

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

}


