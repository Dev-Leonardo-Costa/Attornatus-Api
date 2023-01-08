package com.attornatus.domain.model;


import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Address {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

}


