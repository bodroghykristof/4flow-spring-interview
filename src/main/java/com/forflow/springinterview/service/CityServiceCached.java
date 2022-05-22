package com.forflow.springinterview.service;

import com.forflow.springinterview.dto.CityOutboundDTO;
import com.forflow.springinterview.dto.GeoDBResponse;
import com.forflow.springinterview.entity.City;
import com.forflow.springinterview.entity.CityFactory;
import com.forflow.springinterview.mapper.CityOutboundDTOMapper;
import com.forflow.springinterview.repository.CityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CityServiceCached implements CityService {

    private final CityRepository cityRepository;

    public CityServiceCached(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
        cityRepository.saveAll(CityFactory.createSampleDataCities());
    }

    @Override
    public ResponseEntity<CityOutboundDTO> getCityByWikiDataId(String wikiDataId) {
        City city = cityRepository.findByWikiDataId(wikiDataId);
        return new ResponseEntity<>(CityOutboundDTOMapper.createFrom(city), HttpStatus.OK);
    }
}
