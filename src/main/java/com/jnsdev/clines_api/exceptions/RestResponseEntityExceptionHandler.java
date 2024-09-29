package com.jnsdev.clines_api.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * @Autor Jairo Nascimento
 * @Created 29/09/2024 - 15:09
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler {
    public static final String TIMESTAMP = "timestamp";
    private static final Logger LOOGER = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
    protected ProblemDetail handleConflict(RuntimeException ex) {
        LOOGER.error(ex.getMessage());
        final ProblemDetail problemDetail = ProblemDetail
                .forStatusAndDetail(HttpStatus.CONFLICT, ex.getLocalizedMessage());
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        problemDetail.setDetail(ex.getMessage());
        return problemDetail;
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    protected ProblemDetail notFound(ResourceNotFoundException ex) {
        LOOGER.error(ex.getMessage());
        final ProblemDetail problemDetail = ProblemDetail
                .forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getLocalizedMessage());
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        problemDetail.setDetail(ex.getMessage());
        return problemDetail;
    }
}
