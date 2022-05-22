package com.forflow.springinterview.model.dto.rest;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class CityOutboundDTO implements Serializable {

    private static final long serialVersionUID = -3995222090774711133L;

    private String name;

    private Double latitude;

    private Double longitude;

    private String wikiDataId;

    private String countryIsoCode;
}
