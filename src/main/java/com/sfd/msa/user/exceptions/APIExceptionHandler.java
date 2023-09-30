package com.sfd.msa.user.exceptions;

import com.sfd.msa.user.common.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler {


    @ExceptionHandler({
            NotContentException.class
    })
    public ResponseEntity<Error> notContentDataException(NotContentException notContentException){
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class
    })
    public ResponseEntity<Error> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        return ResponseEntity.badRequest().body(Util.createMethodArgumentValidException(methodArgumentNotValidException, HttpStatus.BAD_REQUEST));
    }
}
