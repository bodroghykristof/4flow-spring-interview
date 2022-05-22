package com.forflow.springinterview.dto.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter @Setter @AllArgsConstructor
public class ErrorResponseDTO implements Serializable {

    private static final long serialVersionUID = 6821928344428294856L;

    private String error;
    private Integer status;
    private Date timestamp;

}
