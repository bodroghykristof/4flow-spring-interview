package com.forflow.springinterview.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CityOutboundDTO {

    private String name;

    private Double latitude;

    private Double longitude;

    private String wikiDataId;

    private String countryIsoCode;
}
