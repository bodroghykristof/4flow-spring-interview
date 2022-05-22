package com.forflow.springinterview.model.dto.wftgeodb;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeoDBResponse implements Serializable {

    private static final long serialVersionUID = 98120010173479130L;

    @JsonProperty("data")
    private Data data;

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CityDTO{" +
                "data=" + data +
                '}';
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Data implements Serializable {

        private static final long serialVersionUID = -2160663862450331946L;

        @JsonProperty("id")
        private Integer id;
        @JsonProperty("wikiDataId")
        private String wikiDataId;
        @JsonProperty("type")
        private String type;
        @JsonProperty("city")
        private String city;
        @JsonProperty("name")
        private String name;
        @JsonProperty("country")
        private String country;
        @JsonProperty("countryCode")
        private String countryCode;
        @JsonProperty("region")
        private String region;
        @JsonProperty("regionCode")
        private String regionCode;
        @JsonProperty("elevationMeters")
        private Integer elevationMeters;
        @JsonProperty("latitude")
        private Double latitude;
        @JsonProperty("longitude")
        private Double longitude;
        @JsonProperty("population")
        private Integer population;
        @JsonProperty("timezone")
        private String timezone;
        @JsonProperty("distance")
        private transient Object distance;
        @JsonProperty("deleted")
        private Boolean deleted;
        @JsonProperty("placeType")
        private String placeType;

        @JsonProperty("id")
        public Integer getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(Integer id) {
            this.id = id;
        }

        @JsonProperty("wikiDataId")
        public String getWikiDataId() {
            return wikiDataId;
        }

        @JsonProperty("wikiDataId")
        public void setWikiDataId(String wikiDataId) {
            this.wikiDataId = wikiDataId;
        }

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String type) {
            this.type = type;
        }

        @JsonProperty("city")
        public String getCity() {
            return city;
        }

        @JsonProperty("city")
        public void setCity(String city) {
            this.city = city;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("country")
        public String getCountry() {
            return country;
        }

        @JsonProperty("country")
        public void setCountry(String country) {
            this.country = country;
        }

        @JsonProperty("countryCode")
        public String getCountryCode() {
            return countryCode;
        }

        @JsonProperty("countryCode")
        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        @JsonProperty("region")
        public String getRegion() {
            return region;
        }

        @JsonProperty("region")
        public void setRegion(String region) {
            this.region = region;
        }

        @JsonProperty("regionCode")
        public String getRegionCode() {
            return regionCode;
        }

        @JsonProperty("regionCode")
        public void setRegionCode(String regionCode) {
            this.regionCode = regionCode;
        }

        @JsonProperty("elevationMeters")
        public Integer getElevationMeters() {
            return elevationMeters;
        }

        @JsonProperty("elevationMeters")
        public void setElevationMeters(Integer elevationMeters) {
            this.elevationMeters = elevationMeters;
        }

        @JsonProperty("latitude")
        public Double getLatitude() {
            return latitude;
        }

        @JsonProperty("latitude")
        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        @JsonProperty("longitude")
        public Double getLongitude() {
            return longitude;
        }

        @JsonProperty("longitude")
        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        @JsonProperty("population")
        public Integer getPopulation() {
            return population;
        }

        @JsonProperty("population")
        public void setPopulation(Integer population) {
            this.population = population;
        }

        @JsonProperty("timezone")
        public String getTimezone() {
            return timezone;
        }

        @JsonProperty("timezone")
        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        @JsonProperty("distance")
        public Object getDistance() {
            return distance;
        }

        @JsonProperty("distance")
        public void setDistance(Object distance) {
            this.distance = distance;
        }

        @JsonProperty("deleted")
        public Boolean getDeleted() {
            return deleted;
        }

        @JsonProperty("deleted")
        public void setDeleted(Boolean deleted) {
            this.deleted = deleted;
        }

        @JsonProperty("placeType")
        public String getPlaceType() {
            return placeType;
        }

        @JsonProperty("placeType")
        public void setPlaceType(String placeType) {
            this.placeType = placeType;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "id=" + id +
                    ", wikiDataId='" + wikiDataId + '\'' +
                    ", type='" + type + '\'' +
                    ", city='" + city + '\'' +
                    ", name='" + name + '\'' +
                    ", country='" + country + '\'' +
                    ", countryCode='" + countryCode + '\'' +
                    ", region='" + region + '\'' +
                    ", regionCode='" + regionCode + '\'' +
                    ", elevationMeters=" + elevationMeters +
                    ", latitude=" + latitude +
                    ", longitude=" + longitude +
                    ", population=" + population +
                    ", timezone='" + timezone + '\'' +
                    ", distance=" + distance +
                    ", deleted=" + deleted +
                    ", placeType='" + placeType + '\'' +
                    '}';
        }

    }

}
