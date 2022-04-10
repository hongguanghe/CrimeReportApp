package com.example.crimereport.data;

import java.util.HashMap;
import java.util.Map;
/*

    Earliest Year of data available is 1985 for Provo

 */
public class allyearlyData {

    private Map<Integer, yearData> yearlyData = new HashMap<Integer,yearData>();

    private void addYear(yearData y) {
        this.yearlyData.put(y.getYear(),y);
    }

    private void removeYear(Integer year) {
        this.yearlyData.remove(year);
    }

    private yearData getYearData(int year) {
        return this.yearlyData.get(year);
    }

    public Map<Integer, yearData> getYearlyData() {
        return yearlyData;
    }

    public void setYearlyData(Map<Integer, yearData> yearlyData) {
        this.yearlyData = yearlyData;
    }
}
