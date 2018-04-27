package com.company.gardens;

import com.company.Plant;

import java.util.ArrayList;

public class Garden {
    private String gardenName;
    private GardenSize gardenSize;
    ArrayList<Plant> plantsList;

    public Garden(String gardenName, GardenSize gardenSize ) {
        this.gardenName = gardenName;
        this.gardenSize = gardenSize;
        plantsList = new ArrayList<Plant>();
    }

    public String getGardenName() {
        return gardenName;
    }

    public ArrayList<Plant> getPlantsList() {
        return plantsList;
    }


}
