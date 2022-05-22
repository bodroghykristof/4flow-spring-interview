package com.forflow.springinterview.service;

import com.forflow.springinterview.dto.rest.CityOutboundDTO;

public interface CityService {
    CityOutboundDTO getCityByWikiDataId(String wikiDataId);

    void save(CityOutboundDTO city);

}
