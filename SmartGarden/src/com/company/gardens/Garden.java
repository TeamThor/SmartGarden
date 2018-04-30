package com.company.gardens;

import com.company.Plant;

import java.util.ArrayList;

public abstract class Garden {
    private String gardenName;
    private GardenSize gardenSize;
    ArrayList<Plant> plantList;

    public Garden(String gardenName, GardenSize gardenSize ) {
        this.gardenName = gardenName;
        this.gardenSize = gardenSize;
    }

    public String getGardenName() {
        return gardenName;
    }




}
