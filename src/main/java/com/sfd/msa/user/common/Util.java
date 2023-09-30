package com.sfd.msa.user.common;

import com.sfd.msa.user.exceptions.Error;
import com.sfd.msa.user.exceptions.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

public class Util {

    public static Error createMethodArgumentValidException(MethodArgumentNotValidException exception, HttpStatus status){
        List<ErrorDetail> errorDetails =exception.getBindingResult().getAllErrors().stream()
                .map(error -> {
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
                    return ErrorDetail.builder().message(fieldName+" "+errorMessage).build();
                })
                .toList();
        return Error.builder().title(Constant.TITLE_ARGUMENT_VALIDATIONS).detail("Error de validacion en argumentos").errors(errorDetails)
                .status(status.value()).build();
    }
}
