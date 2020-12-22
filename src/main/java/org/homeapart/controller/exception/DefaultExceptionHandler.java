package org.homeapart.controller.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.homeapart.controller.response.ErrorMassages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
}
