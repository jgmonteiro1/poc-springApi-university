package com.jgmonteiro.university.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MateriaException extends RuntimeException{

    private static final long serialVersionUID = -8247214704219936918L;

    private final HttpStatus httpStatus;

    public MateriaException(final String message, final HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }
}
