package com.forflow.springinterview.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.forflow.springinterview.model.dto.wftgeodb.getbyname.GeoDBListResponse;
import com.forflow.springinterview.model.dto.wftgeodb.getbywikidataid.GeoDBError;
import com.forflow.springinterview.model.dto.wftgeodb.getbywikidataid.GeoDBErrorResponse;
import com.forflow.springinterview.model.dto.wftgeodb.getbywikidataid.GeoDBErrorCode;
import com.forflow.springinterview.model.mapper.CityOutboundDTOMapper;
import com.forflow.springinterview.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.forflow.springinterview.model.dto.rest.CityOutboundDTO;
import com.forflow.springinterview.model.dto.wftgeodb.getbywikidataid.GeoDBResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class CityServiceExternalAPI implements CityService {

    @Value("${geo_db.base_url}")
    private String GEO_DB_BASE_URL;
    @Value("${geo_db.host}")
    private String HOST_VALUE;
    @Value("${geo_db.api_key}")
    private String API_KEY;

    private static final String CITIES_PATH = "/v1/geo/cities";
    private static final String HOST_HEADER_NAME ="x-rapidapi-host";
    private static final String KEY_HEADER_NAME = "x-rapidapi-key";
    private static final String NAME_PREFIX_QUERY_PARAM_KEY = "namePrefix";

    @Override
    public CityOutboundDTO getCityByWikiDataId(String wikiDataId) {

        String fullURL = GEO_DB_BASE_URL + CITIES_PATH + "/" + wikiDataId;

        try {
            ResponseEntity<GeoDBResponse> responseEntity = sendGetRequest(fullURL, GeoDBResponse.class);
            return CityOutboundDTOMapper.createFrom(responseEntity.getBody());
        } catch (HttpStatusCodeException e) {
            return handleAPICallError(e);
        }

    }

    private CityOutboundDTO handleAPICallError(HttpStatusCodeException e) {
        log.error("CityServiceExternalAPI.handleAPICallError() :: error while calling third party API; error: " + e, e);
        if (HttpStatus.NOT_FOUND.equals(e.getStatusCode())) {
            try {
                GeoDBErrorResponse errorResponse = new ObjectMapper().readValue(e.getResponseBodyAsString(), GeoDBErrorResponse.class);
                log.error("CityServiceExternalAPI.handleAPICallError() :: error response: {}", errorResponse);
                if (!errorResponse.getErrors().isEmpty()) {
                    GeoDBError error = errorResponse.getErrors().get(0);
                    if (GeoDBErrorCode.ENTITY_NOT_FOUND.toString().equals(error.getCode())) {
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
        // we only have read-access to third party API there is no mean to update its data
        throw new UnsupportedOperationException();
    }

    @Override
    public CityOutboundDTO getCityByName(String name) {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put(NAME_PREFIX_QUERY_PARAM_KEY, name);
        String fullURL = HttpUtil.addQueryParameters(GEO_DB_BASE_URL + CITIES_PATH, queryParameters);

        while (fullURL != null) {
            ResponseEntity<GeoDBListResponse> responseEntity = sendGetRequest(fullURL, GeoDBListResponse.class);
            if (responseEntity.getBody() == null) {
                throw new RuntimeException("Error while calling third party API");
            }
            Optional<GeoDBListResponse.Data> exactMatch = responseEntity.getBody()
                                                                        .getData()
                                                                        .stream()
                                                                        .filter(x -> name.equalsIgnoreCase(x.getName()))
                                                                        .findFirst();
            if (exactMatch.isPresent()) return CityOutboundDTOMapper.createFrom(exactMatch.get());
            String nextLink = responseEntity.getBody().getNextLink();
            fullURL = nextLink != null ? GEO_DB_BASE_URL + nextLink : null;
            // this if here because of the rate limit define by the API
            // better approach would be manually setting limit and offset
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }

    private <T> ResponseEntity<T> sendGetRequest(String url, Class<T> clazz) {
        log.info("CityServiceExternalAPI.sendGetRequest() :: calling {}", url);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HOST_HEADER_NAME, HOST_VALUE);
        headers.add(KEY_HEADER_NAME, API_KEY);
        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url, HttpMethod.GET, requestEntity, clazz);
    }

}
