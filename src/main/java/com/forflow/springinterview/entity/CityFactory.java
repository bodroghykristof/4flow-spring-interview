package com.forflow.springinterview.entity;

import java.util.ArrayList;
import java.util.List;

public class CityFactory {

    public static List<City> createSampleDataCities() {
        List<City> cities = new ArrayList<>();
        City losAngeles = new City("Los Angeles" , 34.05223, -118.24368, "Q65", "US");
        City tokio = new City("Tokyo" , 35.689722222, 139.692222222, "Q1490", "JP");
        cities.add(losAngeles);
        cities.add(tokio);
        return cities;
    }

}
