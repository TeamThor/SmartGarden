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
}
