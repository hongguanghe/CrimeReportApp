package com.example.crimereport.data;

public class yearData {

    /*

    The following numbers are strictly associated with private int year

     */
    private int year = 0;
    private int aggravated_assault = 0;
    private int burglary = 0;
    private int larceny = 0;
    private int motor_vehicle_theft = 0;
    private int homicide = 0;
    private int rape = 0;
    private int robbery = 0;
    private int arson = 0;
    private int violent_crime = 0;
    private int property_crime = 0;

    public yearData(int year, int aggravated_assault, int burglary, int larceny, int motor_vehicle_theft, int homicide, int rape, int robbery, int arson, int violent_crime, int property_crime) {
        this.year = year;
        this.aggravated_assault = aggravated_assault;
        this.burglary = burglary;
        this.larceny = larceny;
        this.motor_vehicle_theft = motor_vehicle_theft;
        this.homicide = homicide;
        this.rape = rape;
        this.robbery = robbery;
        this.arson = arson;
        this.violent_crime = violent_crime;
        this.property_crime = property_crime;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAggravated_assault() {
        return aggravated_assault;
    }

    public void setAggravated_assault(int aggravated_assault) {
        this.aggravated_assault = aggravated_assault;
    }

    public int getBurglary() {
        return burglary;
    }

    public void setBurglary(int burglary) {
        this.burglary = burglary;
    }

    public int getLarceny() {
        return larceny;
    }

    public void setLarceny(int larceny) {
        this.larceny = larceny;
    }

    public int getMotor_vehicle_theft() {
        return motor_vehicle_theft;
    }

    public void setMotor_vehicle_theft(int motor_vehicle_theft) {
        this.motor_vehicle_theft = motor_vehicle_theft;
    }

    public int getHomicide() {
        return homicide;
    }

    public void setHomicide(int homicide) {
        this.homicide = homicide;
    }

    public int getRape() {
        return rape;
    }

    public void setRape(int rape) {
        this.rape = rape;
    }

    public int getRobbery() {
        return robbery;
    }

    public void setRobbery(int robbery) {
        this.robbery = robbery;
    }

    public int getArson() {
        return arson;
    }

    public void setArson(int arson) {
        this.arson = arson;
    }

    public int getViolent_crime() {
        return violent_crime;
    }

    public void setViolent_crime(int violent_crime) {
        this.violent_crime = violent_crime;
    }

    public int getProperty_crime() {
        return property_crime;
    }

    public void setProperty_crime(int property_crime) {
        this.property_crime = property_crime;
    }
}
