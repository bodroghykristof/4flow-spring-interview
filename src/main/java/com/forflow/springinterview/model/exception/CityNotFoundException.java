package com.forflow.springinterview.model.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 2165052286434733480L;

    private String keyword;

    public CityNotFoundException(String keyword) {
        super();
        this.keyword = keyword;
    }

}
