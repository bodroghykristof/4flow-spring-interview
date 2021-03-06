package com.forflow.springinterview.model.mapper;

import com.forflow.springinterview.model.dto.rest.CityOutboundDTO;
import com.forflow.springinterview.model.dto.wftgeodb.getbyname.GeoDBListResponse;
import com.forflow.springinterview.model.dto.wftgeodb.getbywikidataid.GeoDBResponse;
import com.forflow.springinterview.model.entity.City;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CityOutboundDTOMapper {

    public static CityOutboundDTO createFrom(GeoDBResponse geoDBResponse) {
        if (geoDBResponse == null) return null;
        GeoDBResponse.Data data = geoDBResponse.getData();
        CityOutboundDTO city = new CityOutboundDTO();
        city.setName(data.getName());
        city.setLatitude(data.getLatitude());
        city.setLongitude(data.getLongitude());
        city.setWikiDataId(data.getWikiDataId());
        city.setCountryIsoCode(data.getCountryCode());
        return city;
    }

    public static CityOutboundDTO createFrom(City cityEntity) {
        if (cityEntity == null) return null;
        CityOutboundDTO city = new CityOutboundDTO();
        city.setName(cityEntity.getName());
        city.setLatitude(cityEntity.getLatitude());
        city.setLongitude(cityEntity.getLongitude());
        city.setWikiDataId(cityEntity.getWikiDataId());
        city.setCountryIsoCode(cityEntity.getCountryIsoCode());
        return city;
    }

    public static CityOutboundDTO createFrom(GeoDBListResponse.Data geoDBResponse) {
        if (geoDBResponse == null) return null;
        CityOutboundDTO city = new CityOutboundDTO();
        city.setName(geoDBResponse.getName());
        city.setLatitude(geoDBResponse.getLatitude());
        city.setLongitude(geoDBResponse.getLongitude());
        city.setWikiDataId(geoDBResponse.getWikiDataId());
        city.setCountryIsoCode(geoDBResponse.getCountryCode());
        return city;
    }
}
