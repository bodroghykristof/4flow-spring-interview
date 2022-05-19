package com.forflow.springinterview.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forflow.springinterview.dto.CityOutboundDTO;
import com.forflow.springinterview.dto.GeoDBResponse;
import com.forflow.springinterview.service.CityServiceExternalAPI;

@RestController
@RequestMapping(CityController.ROOT_PATH)
public class CityController {
    public static final String ROOT_PATH = "city";
    private final CityServiceExternalAPI cityService;

    public CityController(CityServiceExternalAPI cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/wikiDataId/{wikiDataId}")
    public ResponseEntity<CityOutboundDTO> getCityByWikiDataId(@PathVariable String wikiDataId) {
        return cityService.getCityByWikiDataId(wikiDataId);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<GeoDBResponse> getCityByName(@PathVariable String cityName) {
        throw new UnsupportedOperationException();
    }

}
