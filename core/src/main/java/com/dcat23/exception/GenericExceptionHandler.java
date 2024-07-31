package com.dcat23.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
public abstract class GenericExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> genericExceptionHandler(
            Exception e,
            HttpServletRequest request
    ) {
        String message = String.format("%s: %s", e.getClass().getSimpleName(), e.getMessage());
        log.error(message);
        ErrorMessage errorMessage = new ErrorMessage(
                request.getRequestURI(),
                message,
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler(GenericNotFoundException.class)
    public ResponseEntity<ErrorMessage> genericNotFoundExceptionHandler(
            GenericNotFoundException e,
            HttpServletRequest request
    ) {
        ErrorMessage errorMessage = new ErrorMessage(
                request.getRequestURI(),
                e.getMessage(),
                e.getStatusCode(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(e.getStatusCode()).body(errorMessage);
    }
}
