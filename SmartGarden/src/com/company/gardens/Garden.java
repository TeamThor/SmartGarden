package com.company.gardens;

import com.company.Plant;

import java.util.ArrayList;

public abstract class Garden {
    private String gardenName;

    private GardenSize gardenSize;
    private ArrayList<Plant> plantList;

    public Garden(String gardenName, GardenSize gardenSize ) {
        setGardenName(gardenName);
        setGardenSize(gardenSize);
        plantList = new ArrayList<>();
    }

    public String getGardenName() {
        return gardenName;
    }

    public ArrayList<Plant> getPlantList() {
        return plantList;
    }

    public void setGardenName(String gardenName) {
        this.gardenName = gardenName;
    }

    public void setGardenSize(GardenSize gardenSize) {
        this.gardenSize = gardenSize;
    }

    public void addPlant(Plant plant){
        plantList.add(plant);
    }

    @Override
    public boolean equals(Object obj) {
        return this.gardenName.equals(((Garden) obj).gardenName);
    }
}
