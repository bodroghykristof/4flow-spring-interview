package com.forflow.springinterview.service;

import com.forflow.springinterview.entity.CityFactory;
import com.forflow.springinterview.repository.CityRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.forflow.springinterview.dto.CityOutboundDTO;
import com.forflow.springinterview.dto.GeoDBResponse;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
        cityRepository.saveAll(CityFactory.createSampleDataCities());
    }

    public ResponseEntity<GeoDBResponse> getCityByWikiDataId(String wikiDataId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-host", "wft-geo-db.p.rapidapi.com");
        headers.add("x-rapidapi-key", "3c0beb7455msheac4246653cbe61p1d6170jsndd04c7b08e83");

        String cityResourceUrl
                = "https://wft-geo-db.p.rapidapi.com/v1/geo/cities/";
        ResponseEntity<GeoDBResponse> responseEntity
                = restTemplate.exchange(cityResourceUrl + wikiDataId, HttpMethod.GET, new HttpEntity<>(headers), GeoDBResponse.class);

        System.out.println(responseEntity.getBody());
        return responseEntity;
    }

    ///////////////// TODO INTERVIEWER CODE COMES FROM HERE ///////////////////

    public ResponseEntity<CityOutboundDTO> getCity(String wikiDataId) {
        // readCityFromDB(wikiDataId);
        // if not found
        //      getCityByWikiDataId(String wikiDataId);

        throw new UnsupportedOperationException();
    }

}
