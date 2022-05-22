package com.forflow.springinterview.controller;

import com.forflow.springinterview.dto.rest.ErrorResponseDTO;
import com.forflow.springinterview.exception.CityNotFoundException;
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
        log.error("City was not found with wikiDataId {}", e.getWikiDataId());
        return createErrorResponse("City was not found with wikiDataId " + e.getWikiDataId(), HttpStatus.NOT_FOUND);
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
