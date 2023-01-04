package com.attornatus.domain.exception;

import java.io.Serial;

public class PersonNotFoundException extends EntityNotFoundException{

    @Serial
    private static final long serialVersionUID = 1L;
    public PersonNotFoundException(String message) {
        super(message);
    }
    public PersonNotFoundException(Long personId) {
        this(String.format("There is no registration of person with code %d", personId));
    }

}