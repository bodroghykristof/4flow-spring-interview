package com.forflow.springinterview.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.forflow.springinterview.dto.CityOutboundDTO;
import com.forflow.springinterview.dto.GeoDBResponse;

@Service
public class CityServiceExternalAPI implements CityService {

    @Override
    public ResponseEntity<CityOutboundDTO> getCityByWikiDataId(String wikiDataId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-host", "wft-geo-db.p.rapidapi.com");
        headers.add("x-rapidapi-key", "3c0beb7455msheac4246653cbe61p1d6170jsndd04c7b08e83");

        String cityResourceUrl
                = "https://wft-geo-db.p.rapidapi.com/v1/geo/cities/";
        ResponseEntity<GeoDBResponse> responseEntity
                = restTemplate.exchange(cityResourceUrl + wikiDataId, HttpMethod.GET, new HttpEntity<>(headers), GeoDBResponse.class);

        // TODO map the result to desired format
        System.out.println(responseEntity.getBody());
        return new ResponseEntity<CityOutboundDTO>(HttpStatus.I_AM_A_TEAPOT);
    }

}
