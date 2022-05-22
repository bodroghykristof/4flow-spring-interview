package com.forflow.springinterview.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 2165052286434733480L;

    private String wikiDataId;

    public CityNotFoundException(String wikiDataId) {
        super();
        this.wikiDataId = wikiDataId;
    }

}
