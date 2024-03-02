package com.aulamatriz.product.exception;


import com.aulamatriz.product.config.ExceptionConfigs;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@ControllerAdvice
public class HandleException {

    private final ExceptionConfigs exceptionConfigs;

    @ExceptionHandler(MyHandleException.class)
    public ResponseEntity<Object> handleMyHandleException(MyHandleException ex){
        log.error(
                "{} {}",
                exceptionConfigs.getExceptionMessage(ExceptionConfigs.BUSINESS)
                ,ex.getMessage()
        );
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex){
        log.error(
                "{} {}",
                exceptionConfigs.getExceptionMessage(ExceptionConfigs.SYSTEM)
                ,ex.getMessage()
        );
        return ResponseEntity
                .status(
                        HttpStatus.INTERNAL_SERVER_ERROR
                )
                .body(ex.getMessage());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleValidationException(MethodArgumentNotValidException ex){
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()){
            //rrors.add(error.getObjectName()+" field "+error.getField() + " Error " +  error.getDefaultMessage());
            errors.add("""
                    %s field  [ %s ]  Error %s"""
                    .formatted(error.getObjectName(),error.getField(), error.getDefaultMessage())
            );
        }
        log.error("{} error info : \n {}",exceptionConfigs.getExceptionMessage(ExceptionConfigs.SYSTEM),errors);

        return ResponseEntity.badRequest().body(errors);
    }
}
