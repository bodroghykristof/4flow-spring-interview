package com.forflow.springinterview.service;

import com.forflow.springinterview.dto.CityOutboundDTO;
import org.springframework.http.ResponseEntity;

public interface CityService {
    ResponseEntity<CityOutboundDTO> getCityByWikiDataId(String wikiDataId);
}
