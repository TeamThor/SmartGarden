package com.company.gardens;

import com.company.Plant;
import com.company.Vegetable;

import java.util.ArrayList;

public class VeggieGarden extends Garden implements PlantDisplayable, VegetableAddable {


    public VeggieGarden(String gardenName, GardenSize gardenSize) {
        super(gardenName, gardenSize);
        
    }

    @Override
    public void addVegetable(Vegetable vegetable){
        getPlantList().add(vegetable);
    }

    @Override
    public void displayList() {
        getPlantList().forEach(System.out::println);
    }

    @Override
    public String toString() {
        if (this.getGardenSize() == GardenSize.LARGE){
            return String.format(" %s: Large Vegetable Garden", this.getGardenName());
        }
        else{
            return this.getGardenSize()==GardenSize.MEDIUM?
                    String.format(" %s: Medium Vegetable Garden", this.getGardenName()):
                    String.format(" %s: Small Vegetable Garden", this.getGardenName());
        }
    }

}
