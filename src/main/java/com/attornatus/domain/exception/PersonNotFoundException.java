package com.attornatus.domain.exception;

public class PersonNotFoundException extends EntityNotFoundException{

    private static final long serialVersionUID = 1L;
    public PersonNotFoundException(String message) {
        super(message);
    }
    public PersonNotFoundException(Integer personId) {
        this(String.format("Não existe um cadastro de pessoa com código %d", personId));
    }

}