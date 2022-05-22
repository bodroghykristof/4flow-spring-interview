package com.forflow.springinterview.model.mapper;

import com.forflow.springinterview.model.dto.rest.CityOutboundDTO;
import com.forflow.springinterview.model.entity.City;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CityMapper {

    public static City createFrom(CityOutboundDTO dto) {
        if (dto == null) return null;
        City city = new City();
        city.setName(dto.getName());
        city.setLatitude(dto.getLatitude());
        city.setLongitude(dto.getLongitude());
        city.setWikiDataId(dto.getWikiDataId());
        city.setCountryIsoCode(dto.getCountryIsoCode());
        return city;
    }

}
