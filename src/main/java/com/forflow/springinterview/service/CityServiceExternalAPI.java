package com.forflow.springinterview.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.forflow.springinterview.dto.wftgeodb.GeoDBError;
import com.forflow.springinterview.dto.wftgeodb.GeoDBErrorResponse;
import com.forflow.springinterview.dto.wftgeodb.GeoDbErrorCode;
import com.forflow.springinterview.mapper.CityOutboundDTOMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.forflow.springinterview.dto.rest.CityOutboundDTO;
import com.forflow.springinterview.dto.wftgeodb.GeoDBResponse;

@Service
@Slf4j
public class CityServiceExternalAPI implements CityService {

    private static final String GEO_DB_URL = "https://wft-geo-db.p.rapidapi.com/v1/geo/cities/";

    private static final String HOST_HEADER_NAME ="x-rapidapi-host";
    private static final String KEY_HEADER_NAME = "x-rapidapi-key";
    private static final String HOST_VALUE = "wft-geo-db.p.rapidapi.com";
    private static final String API_KEY = "3c0beb7455msheac4246653cbe61p1d6170jsndd04c7b08e83s";

    @Override
    public CityOutboundDTO getCityByWikiDataId(String wikiDataId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HOST_HEADER_NAME, HOST_VALUE);
        headers.add(KEY_HEADER_NAME, API_KEY);

        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        String fullURL = GEO_DB_URL + wikiDataId;

        log.info("CityServiceExternalAPI.getCityByWikiDataId() :: calling {}", fullURL);

        try {
            ResponseEntity<GeoDBResponse> responseEntity = restTemplate.exchange(fullURL,
                                                                                 HttpMethod.GET,
                                                                                 requestEntity,
                                                                                 GeoDBResponse.class);
            return CityOutboundDTOMapper.createFrom(responseEntity.getBody());
        } catch (HttpStatusCodeException e) {
            return handleAPICallError(e);
        }
    }

    private CityOutboundDTO handleAPICallError(HttpStatusCodeException e) {
        log.error("CityServiceExternalAPI.handleAPICallError() :: error while calling 3rd party API; error: " + e, e);
        if (HttpStatus.NOT_FOUND.equals(e.getStatusCode())) {
            try {
                GeoDBErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), GeoDBErrorResponse.class);
                log.error("CityServiceExternalAPI.handleAPICallError() :: error response: {}", errorResponse);
                if (!errorResponse.getErrors().isEmpty()) {
                    GeoDBError error = errorResponse.getErrors().get(0);
                    if (GeoDbErrorCode.ENTITY_NOT_FOUND.toString().equals(error.getCode())) {
                        return null;
                    }
                }
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
        }
        throw e;
    }

    @Override
    public void save(CityOutboundDTO city) {
        // we only have read-access to 3rd party API there is no mean to update its data
        throw new UnsupportedOperationException();
    }

}
