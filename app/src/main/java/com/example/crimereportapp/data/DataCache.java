package com.example.crimereport.data;

public class DataCache {

    private static DataCache _instance = new DataCache();
    public static DataCache getInstance() {
        return _instance;
    }


    private final String API_KEY = "kKwI7EbdXw219bH0Aqja5unjaxjYzhhndxBlxnnx";
    private String cityORI = "UT0250600"; //currently provoURI

    private allyearlyData allyearlyData = new allyearlyData();

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

    public com.example.crimereport.data.allyearlyData getAllyearlyData() {
        return allyearlyData;
    }

    public void setAllyearlyData(com.example.crimereport.data.allyearlyData allyearlyData) {
        this.allyearlyData = allyearlyData;
    }
}
