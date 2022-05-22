package com.forflow.springinterview.controller;

import com.forflow.springinterview.service.CityServiceCached;
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
    private final CityServiceExternalAPI cityServiceExternalAPI;
    private final CityServiceCached cityServiceCached;

    public CityController(CityServiceExternalAPI cityServiceExternalAPI, CityServiceCached cityServiceCached) {
        this.cityServiceExternalAPI = cityServiceExternalAPI;
        this.cityServiceCached = cityServiceCached;
    }

    @GetMapping("/wikiDataId/{wikiDataId}")
    public ResponseEntity<CityOutboundDTO> getCityByWikiDataId(@PathVariable String wikiDataId) {
        return cityServiceExternalAPI.getCityByWikiDataId(wikiDataId);
        // return cityServiceCached.getCityByWikiDataId(wikiDataId);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<GeoDBResponse> getCityByName(@PathVariable String cityName) {
        throw new UnsupportedOperationException();
    }

}
