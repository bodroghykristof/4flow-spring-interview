package com.forflow.springinterview.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City {
    @Id
    @Column(name = "ID", updatable = false, nullable = false, length = 19)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LATITUDE", precision = 15, scale = 10)
    private Double latitude;

    @Column(name = "LONGITUDE", precision = 15, scale = 10)
    private Double longitude;

    @Column(name = "WIKI_DATA_ID")
    private String wikiDataId;

    @Column(name = "COUNTRY_ISO_2")
    private String countryIsoCode;

    public City() {}

    public City(String name, Double latitude, Double longitude, String wikiDataId, String countryIsoCode) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.wikiDataId = wikiDataId;
        this.countryIsoCode = countryIsoCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getWikiDataId() {
        return wikiDataId;
    }

    public void setWikiDataId(String wikiDataId) {
        this.wikiDataId = wikiDataId;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }
}
