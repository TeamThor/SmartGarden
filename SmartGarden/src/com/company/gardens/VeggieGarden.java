package com.company.gardens;

import com.company.Plant;

import java.util.ArrayList;

public class VeggieGarden extends Garden {




    public VeggieGarden(String gardenName, GardenSize gardenSize) {
        super(gardenName, gardenSize);
        plantList = new ArrayList<>();
    }



}
