package com.company.gardens;

import com.company.Plant;

import java.util.ArrayList;

public class VeggieGarden extends Garden {


    public VeggieGarden(String gardenName, GardenSize gardenSize) {
        super(gardenName, gardenSize);
        
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
