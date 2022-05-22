package com.forflow.springinterview.service;

import com.forflow.springinterview.model.dto.rest.CityOutboundDTO;
import com.forflow.springinterview.model.entity.City;
import com.forflow.springinterview.model.entity.CityFactory;
import com.forflow.springinterview.model.mapper.CityMapper;
import com.forflow.springinterview.model.mapper.CityOutboundDTOMapper;
import com.forflow.springinterview.repository.CityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CityServiceCached implements CityService {

    private final CityRepository cityRepository;

    public CityServiceCached(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
        cityRepository.saveAll(CityFactory.createSampleDataCities());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public CityOutboundDTO getCityByWikiDataId(String wikiDataId) {
        City city = cityRepository.findByWikiDataId(wikiDataId);
        return CityOutboundDTOMapper.createFrom(city);
    }

    @Override
    @Transactional
    public void save(CityOutboundDTO city) {
        City entity = CityMapper.createFrom(city);
        cityRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public CityOutboundDTO getCityByName(String name) {
        City city = cityRepository.findByNameIgnoreCase(name);
        return CityOutboundDTOMapper.createFrom(city);
    }
}
