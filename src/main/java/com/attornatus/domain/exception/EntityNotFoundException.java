package com.attornatus.domain.exception;

import java.io.Serial;

public abstract class EntityNotFoundException extends BusinessException{

    @Serial
    private static  final long serialVersionUID = 1L;

    public EntityNotFoundException(String message) {
        super(message);
    }

}