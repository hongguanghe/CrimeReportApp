package com.example.crimereportapp.data;

import java.util.HashMap;
import java.util.Map;

public class RandomDataGeneration {

    private int rangeLower = 50;
    private int rangeUpper = 200;

    public allyearlyData generateRandomAllYearlyData(){

        allyearlyData allyearlyData = new allyearlyData();

        Map<Integer,yearData> randomYearlyData = new HashMap<>();

        for (int x = 1985; x<= 2020; x++) {
            yearData randYearData = new yearData(x,randomDataInRange(),randomDataInRange(),randomDataInRange(),randomDataInRange(),randomDataInRange(),randomDataInRange(),randomDataInRange(),randomDataInRange(),randomDataInRange(), randomDataInRange());
            randomYearlyData.put(x, randYearData);
        }

        allyearlyData.setYearlyData(randomYearlyData);

        return allyearlyData;
    }


    private int randomDataInRange() {
        return (int)Math.floor(Math.random()*(rangeUpper-rangeLower+1)+rangeLower);
    }

}
