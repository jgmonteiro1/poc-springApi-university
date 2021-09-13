package com.jgmonteiro.university.handler;

import com.jgmonteiro.university.exceptions.MateriaException;
import com.jgmonteiro.university.model.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(MateriaException.class)
    public ResponseEntity<ErrorResponse> handlerMateriaException(MateriaException exception){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .httpStatus(exception.getHttpStatus().value())
                .mensagem(exception.getMessage())
                .timeStamp(System.currentTimeMillis())
                .build();
        return ResponseEntity.status(exception.getHttpStatus()).body(errorResponse);
    }
}
