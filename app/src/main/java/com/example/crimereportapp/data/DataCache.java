package com.example.crimereportapp.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class DataCache {

    private static DataCache _instance = new DataCache();

    private final String API_KEY = "kKwI7EbdXw219bH0Aqja5unjaxjYzhhndxBlxnnx";
    private String cityORI = "UT0250600"; //currently provoURI

    private allyearlyData allyearlyData = new allyearlyData();

    private String currentCityName = "";

    private String[] cities = {"Salt Lake City",
            "West Valley City",
            "Provo",
            "West Jordan",
            "Orem",
            "Sandy",
            "Ogden",
            "St. George",
            "Layton",
            "Taylorsville",
            "South Jordan",
            "Lehi",
            "Logan",
            "Murray",
            "Draper",
            "Bountiful",
            "Riverton",
            "Roy"};

    private int[] zipCodes = {84150,
            84120,
            84606

    };

    public static DataCache get_instance() {
        return _instance;
    }

    private void populateYearlyData() {
        //using ProvoORI, populate each year available
    }

    private void makeRandomData(){
        this.allyearlyData = new RandomDataGeneration().generateRandomAllYearlyData();
    }

    public String getCityORI() {
        return cityORI;
    }

    public void setCityORI(String cityORI) {
        this.cityORI = cityORI;
    }

    public com.example.crimereportapp.data.allyearlyData getAllyearlyData() {
        return allyearlyData;
    }

    public void setAllyearlyData(com.example.crimereportapp.data.allyearlyData allyearlyData) {
        this.allyearlyData = allyearlyData;
    }

    public List<String> getSearchResults(String search) {
        List<String> resultCities = new ArrayList<>();
        for(String str: cityList) {
            if(str.trim().toLowerCase(Locale.ROOT).contains(search))
                resultCities.add(str);
        }
        return resultCities;
    }

    public String getCurrentCityName() {
        return currentCityName;
    }

    public void setCurrentCityName(String currentCityName) {
        this.currentCityName = currentCityName;
    }

}
