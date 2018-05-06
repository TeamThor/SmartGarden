package com.company.gardens;

import com.company.MultipleFruit;



public class Vineyard extends Garden implements PlantDisplayable, GrapeVineAddable {
        public Vineyard(String gardenName, GardenSize gardenSize) {
        super(gardenName, gardenSize);

    }

    @Override
    public void addGrapeVine (MultipleFruit multipleFruit){
            getPlantList().add(multipleFruit);
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
    public void displayList() {
        getPlantList().forEach(System.out::println);
    }
}
