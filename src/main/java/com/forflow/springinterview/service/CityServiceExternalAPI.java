package com.forflow.springinterview.service;

import com.forflow.springinterview.mapper.CityOutboundDTOMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.forflow.springinterview.dto.CityOutboundDTO;
import com.forflow.springinterview.dto.GeoDBResponse;

@Service
public class CityServiceExternalAPI implements CityService {

    private static final String GEO_DB_URL = "https://wft-geo-db.p.rapidapi.com/v1/geo/cities/";

    private static final String HOST_HEADER_NAME ="x-rapidapi-host";
    private static final String KEY_HEADER_NAME = "x-rapidapi-key";
    private static final String HOST_VALUE = "wft-geo-db.p.rapidapi.com";
    private static final String API_KEY = "3c0beb7455msheac4246653cbe61p1d6170jsndd04c7b08e833c0beb7455msheac4246653cbe61p1d6170jsndd04c7b08e83";

    @Override
    public ResponseEntity<CityOutboundDTO> getCityByWikiDataId(String wikiDataId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HOST_HEADER_NAME, HOST_VALUE);
        headers.add(KEY_HEADER_NAME, API_KEY);

        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        String fullURL = GEO_DB_URL + wikiDataId;

        ResponseEntity<GeoDBResponse> responseEntity = restTemplate.exchange(fullURL,
                                                                             HttpMethod.GET,
                                                                             requestEntity,
                                                                             GeoDBResponse.class);

        System.out.println(responseEntity.getBody());
        CityOutboundDTO result = CityOutboundDTOMapper.createFrom(responseEntity.getBody());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
