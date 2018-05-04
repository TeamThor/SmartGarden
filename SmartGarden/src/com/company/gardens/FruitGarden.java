package com.company.gardens;

import com.company.SingleFruit;

public class FruitGarden extends Garden implements PlantDisplayable{

    public FruitGarden(String gardenName, GardenSize gardenSize) {
        super(gardenName, gardenSize);
    }

    public void addFruit(SingleFruit singleFruit){
        getPlantList().add(singleFruit);
    }

    @Override
    public void displayList() {
        getPlantList().forEach(System.out::println);
    }

    @Override
    public String toString() {
        if (this.getGardenSize() == GardenSize.LARGE){
            return String.format(" %s: Large Fruit Garden", this.getGardenName());
        }
        else{
            return this.getGardenSize()==GardenSize.MEDIUM?
                    String.format(" %s: Medium Fruit Garden", this.getGardenName()):
                    String.format(" %s: Small Fruit Garden", this.getGardenName());
        }
    }
}
