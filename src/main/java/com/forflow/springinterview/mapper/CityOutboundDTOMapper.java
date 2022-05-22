package com.forflow.springinterview.mapper;

import com.forflow.springinterview.dto.CityOutboundDTO;
import com.forflow.springinterview.dto.GeoDBResponse;
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

}
