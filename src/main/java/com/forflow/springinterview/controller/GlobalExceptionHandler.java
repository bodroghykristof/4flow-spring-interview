package com.forflow.springinterview.controller;

import com.forflow.springinterview.dto.rest.ErrorResponseDTO;
import com.forflow.springinterview.exception.CityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CityNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleCityNotFound(HttpServletRequest req, CityNotFoundException e) {
        log.error("City was not found with wikiDataId {}", e.getWikiDataId());
        ErrorResponseDTO response = new ErrorResponseDTO("City was not found with wikiDataId " + e.getWikiDataId(),
                                                            HttpStatus.NOT_FOUND.value(),
                                                            new Date());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
