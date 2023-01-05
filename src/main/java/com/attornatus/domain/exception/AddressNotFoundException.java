package com.attornatus.domain.exception;

public class AddressNotFoundException extends EntityNotFoundException{

    private static final long serialVersionUID = 1L;
    public AddressNotFoundException(String message) {
        super(message);
    }

    public AddressNotFoundException(Long enderecoId) {
        this(String.format("Não existe um cadastro de endereço com código %d", enderecoId));
    }

}