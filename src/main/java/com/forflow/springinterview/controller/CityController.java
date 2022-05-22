package com.forflow.springinterview.controller;

import com.forflow.springinterview.exception.CityNotFoundException;
import com.forflow.springinterview.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forflow.springinterview.dto.CityOutboundDTO;
import com.forflow.springinterview.dto.wftgeodb.GeoDBResponse;

@RestController
@RequestMapping(CityController.ROOT_PATH)
public class CityController {

    public static final String ROOT_PATH = "city";
    private final CityService cityServiceExternalAPI;
    private final CityService cityServiceCached;

    public CityController(CityService cityServiceExternalAPI, CityService cityServiceCached) {
        this.cityServiceExternalAPI = cityServiceExternalAPI;
        this.cityServiceCached = cityServiceCached;
    }

    @GetMapping("/wikiDataId/{wikiDataId}")
    public ResponseEntity<CityOutboundDTO> getCityByWikiDataId(@PathVariable String wikiDataId) {
        CityOutboundDTO result = cityServiceCached.getCityByWikiDataId(wikiDataId);
        if (result == null) {
            result = cityServiceExternalAPI.getCityByWikiDataId(wikiDataId);
            if (result != null) {
                cityServiceCached.save(result);
            } else {
                throw new CityNotFoundException();
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<GeoDBResponse> getCityByName(@PathVariable String cityName) {
        throw new UnsupportedOperationException();
    }

}
