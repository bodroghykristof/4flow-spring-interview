package com.forflow.springinterview.mapper;

import com.forflow.springinterview.dto.CityOutboundDTO;
import com.forflow.springinterview.entity.City;
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
