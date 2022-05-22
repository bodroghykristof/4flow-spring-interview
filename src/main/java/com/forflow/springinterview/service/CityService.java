package com.forflow.springinterview.service;

import com.forflow.springinterview.dto.rest.CityOutboundDTO;

public interface CityService {
    CityOutboundDTO getCityByWikiDataId(String wikiDataId);

    CityOutboundDTO getCityByName(String name);

    void save(CityOutboundDTO city);

}
