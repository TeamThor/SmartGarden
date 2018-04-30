package com.company.gardens;

import com.company.ConiferousTree;
import com.company.Tree;

public class ConiferousGarden extends Garden implements TreeAddable, PlantDisplayable{

    public ConiferousGarden(String gardenName, GardenSize gardenSize) {
        super(gardenName, gardenSize);
    }

     @Override
    public void addTree(Tree tree) {
         getPlantList().add(tree);
    }


    @Override
    public void dipslayList() {
        getPlantList().forEach(System.out::print);
    }

    @Override
    public String toString() {
        if (this.getGardenSize() == GardenSize.LARGE){
            return String.format(" %s: Large Coniferous Garden", this.getGardenName());
        }
        else{
            return this.getGardenSize()==GardenSize.MEDIUM?
                    String.format(" %s: Medium Coniferous Garden", this.getGardenName()):
                    String.format(" %s: Small Coniferous Garden", this.getGardenName());
        }
    }
}
