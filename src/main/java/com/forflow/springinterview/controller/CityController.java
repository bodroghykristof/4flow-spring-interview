package com.forflow.springinterview.controller;

import com.forflow.springinterview.model.exception.CityNotFoundException;
import com.forflow.springinterview.model.exception.InvalidParameterException;
import com.forflow.springinterview.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forflow.springinterview.model.dto.rest.CityOutboundDTO;

@Slf4j
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
        log.info("CityController.getCityByWikiDataId :: incoming request to /city/wikiDataId/{}", wikiDataId);
        CityOutboundDTO result = cityServiceCached.getCityByWikiDataId(wikiDataId);
        if (result == null) {
            result = cityServiceExternalAPI.getCityByWikiDataId(wikiDataId);
            if (result != null) {
                cityServiceCached.save(result);
            } else {
                throw new CityNotFoundException(wikiDataId);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/name/{cityName}")
    public ResponseEntity<CityOutboundDTO> getCityByName(@PathVariable String cityName) {
        log.info("CityController.getCityByName :: incoming request to /city/name/{}", cityName);
        if (cityName == null || cityName.length() < 5) {
            throw new InvalidParameterException("City name must be at least 5 characters long");
        }
        CityOutboundDTO result = cityServiceCached.getCityByName(cityName.trim());
        if (result == null) throw new CityNotFoundException(cityName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
