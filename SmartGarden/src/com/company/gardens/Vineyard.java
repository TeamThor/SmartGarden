package com.company.gardens;

import com.company.Plant;
import com.company.Vegetable;

import java.util.ArrayList;

public class Vineyard extends Garden {
        public Vineyard(String gardenName, GardenSize gardenSize) {
        super(gardenName, gardenSize);

    }

    public void addVeggie (String name, String date, int id){

            getPlantList().add(new Vegetable(name, date, id));
    }


}