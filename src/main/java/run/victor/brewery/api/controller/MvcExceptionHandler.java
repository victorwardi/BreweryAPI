package run.victor.brewery.api.controller;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Victor Wardi - @victorwardi on 9/13/2019
 */
@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrosHandler(ConstraintViolationException e) {

        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List> handleBindException(BindException e){

        List<String> erros = new ArrayList<>(e.getAllErrors().size());
        e.getAllErrors().forEach(bindException -> {
            erros.add(bindException.getCode() + " : " + bindException.getObjectName());
        });
        return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);

    }
}
