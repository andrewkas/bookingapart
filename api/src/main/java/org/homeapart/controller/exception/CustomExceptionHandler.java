package org.homeapart.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.homeapart.controller.response.ErrorMassages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
@Log4j2
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {


   @ExceptionHandler(ValidationException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(ConstraintViolationException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
       for (ConstraintViolation<?> error:
            ex.getConstraintViolations()){
           details.add(error.getMessage());
       }
        ErrorMassages error = new ErrorMassages(HttpStatus.UNPROCESSABLE_ENTITY, LocalDateTime.now(),"Validation Failed", details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public  ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorMassages error = new ErrorMassages(HttpStatus.INTERNAL_SERVER_ERROR,LocalDateTime.now(),"Server Error", details);
        return new ResponseEntity(error, HttpStatus.FORBIDDEN.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PersistenceException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());
       ErrorMassages error= new ErrorMassages(NOT_FOUND,LocalDateTime.now(),"EntityNotFound",details);
        return new ResponseEntity(error, NOT_FOUND);
    }


}
