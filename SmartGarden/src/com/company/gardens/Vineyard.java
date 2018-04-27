package com.company.gardens;

import com.company.Plant;

import java.util.ArrayList;

public class Vineyard extends Garden {

    ArrayList<Plant> plantList;
    public Vineyard(String gardenName, GardenSize gardenSize) {
        super(gardenName, gardenSize);
        plantList = new ArrayList<>();
    }
}
