package com.company.gardens;

import com.company.Plant;
import com.company.Vegetable;

import java.util.ArrayList;

public class Vineyard extends Garden implements PlantDisplayable {
        public Vineyard(String gardenName, GardenSize gardenSize) {
        super(gardenName, gardenSize);

    }

    public void addVeggie (String name, String date, int id){
            getPlantList().add(new Vegetable(name, date, id));
    }

    @Override
    public String toString() {
        if (this.getGardenSize() == GardenSize.LARGE){
            return String.format(" %s: Large Vineyard", this.getGardenName());
        }
        else{
            return this.getGardenSize()==GardenSize.MEDIUM?
                    String.format(" %s: Medium Vineyard", this.getGardenName()):
                    String.format(" %s: Small Vineyard", this.getGardenName());
        }
    }

    @Override
    public void dipslayList() {
        getPlantList().forEach(System.out::println);
    }
}
