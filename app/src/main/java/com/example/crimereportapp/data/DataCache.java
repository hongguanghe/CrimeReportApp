package com.example.crimereportapp.data;

import com.anychart.chart.common.dataentry.DataEntry;

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

    private boolean myCitySetAsProvo = false;

    public int provoScore = 0;
    public String currentCityName = "";
    public int currentCityZip = -1;

    public List<DataEntry> summaryData = new ArrayList<>();
    public List<DataEntry> trendData = new ArrayList<>();


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
            84606,
            84088,
            84057,
            84094,
            84401,
            84770,
            84041,
            84118,
            84095,
            84043,
            84321,
            84107,
            84020,
            84010,
            84065,
            84067
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

    public void getSearchResults(String search) {
        List<Integer> resultZips = new ArrayList<>();
        List<String> resultNames = new ArrayList<>();
        for(int i = 0; i < cities.length; i++) {
            if(cities[i].toLowerCase(Locale.ROOT).contains(search.toLowerCase(Locale.ROOT))) {
                resultZips.add(zipCodes[i]);
                resultNames.add(cities[i]);
            }
        }
        currentCityZip = resultZips.get(0);
        currentCityName = resultNames.get(0);
    }

    public void setMyCityAsProvo() {
        myCitySetAsProvo = true;
    }

    public boolean getMyCitySetAsProvo() {
        return myCitySetAsProvo;
    }

    public String getCurrentCityName() {
        return currentCityName;
    }

    public void setCurrentCityName(String currentCityName) {
        this.currentCityName = currentCityName;
    }

}
