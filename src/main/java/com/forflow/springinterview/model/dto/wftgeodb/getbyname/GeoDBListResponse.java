package com.forflow.springinterview.model.dto.wftgeodb.getbyname;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GeoDBListResponse implements Serializable {

    private static final long serialVersionUID = 3623698684863416843L;

    private static final String FIRST_REL = "first";
    private static final String NEXT_REL = "next";
    private static final String LAST_REL = "last";

    public List<Data> data;
    public List<Link> links;
    public Metadata metadata;

    @Getter @Setter
    public static class Data implements Serializable {

        private static final long serialVersionUID = 5737249679288526587L;

        public int id;
        public String wikiDataId;
        public String type;
        public String city;
        public String name;
        public String country;
        public String countryCode;
        public String region;
        public String regionCode;
        public Double latitude;
        public Double longitude;
        public Integer population;

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
                    ", latitude=" + latitude +
                    ", longitude=" + longitude +
                    ", population=" + population +
                    '}';
        }
    }

    public String getNextLink() {
        if (this.links == null || this.links.isEmpty()) return null;
        return this.links.stream()
                         .filter(l -> NEXT_REL.equals(l.getRel()))
                         .map(Link::getHref)
                         .findFirst()
                         .orElse(null);
    }

    @Getter @Setter
    public static class Link implements Serializable {

        private static final long serialVersionUID = 6049969464399372743L;

        public String rel;
        public String href;

        @Override
        public String toString() {
            return "Link{" +
                    "rel='" + rel + '\'' +
                    ", href='" + href + '\'' +
                    '}';
        }
    }

    @Getter @Setter
    public static class Metadata implements Serializable {

        private static final long serialVersionUID = -3992160656580523632L;

        public int currentOffset;
        public int totalCount;

        @Override
        public String toString() {
            return "Metadata{" +
                    "currentOffset=" + currentOffset +
                    ", totalCount=" + totalCount +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "GeoDBListResponse{" +
                "data=" + data +
                ", links=" + links +
                ", metadata=" + metadata +
                '}';
    }
}