package org.homeapart.controller.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.homeapart.controller.response.ErrorMassages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class DefaultExceptionHandler {
    private static final Logger LOGGER = LogManager.getLogger(DefaultExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMassages> handleOthersException(Exception e) {
        LOGGER.error(e.getMessage(), e);
        LOGGER.info(e.getMessage(), e);
        return new ResponseEntity<>(new ErrorMassages( e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

  // @ResponseStatus(HttpStatus.BAD_REQUEST)
  // @ExceptionHandler(MethodArgumentNotValidException.class)
  // public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
  //     Map<String, String> errors = new HashMap<>();
  //     ex.getBindingResult().getAllErrors().forEach((error) -> {
  //         String fieldName = ((FieldError) error).getField();
  //         String errorMessage = error.getDefaultMessage();
  //         errors.put(fieldName, errorMessage);
  //     });
  //     return errors;
  // }
}
