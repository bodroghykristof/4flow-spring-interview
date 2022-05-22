package com.forflow.springinterview.controller;

import com.forflow.springinterview.model.dto.rest.ErrorResponseDTO;
import com.forflow.springinterview.model.exception.CityNotFoundException;
import com.forflow.springinterview.model.exception.InvalidParameterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CityNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleCityNotFound(CityNotFoundException e) {
        log.error("City was not found for {}", e.getKeyword());
        return createErrorResponse("City was not found for " + e.getKeyword(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = InvalidParameterException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidParameterException(InvalidParameterException e) {
        return createErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleUnexpectedError(Exception e) {
        log.error("Unexpected error", e);
        return createErrorResponse("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponseDTO> createErrorResponse(String message, HttpStatus status) {
        ErrorResponseDTO response = new ErrorResponseDTO(message,
                                                         status.value(),
                                                         new Date());
        return new ResponseEntity<>(response, status);
    }

}
