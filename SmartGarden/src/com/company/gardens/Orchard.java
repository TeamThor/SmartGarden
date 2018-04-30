package com.company.gardens;

import com.company.Plant;

import java.util.ArrayList;

public class Orchard extends Garden {

    public Orchard(String gardenName, GardenSize gardenSize) {
        super(gardenName, gardenSize);
        plantList = new ArrayList<>();
    }
}
