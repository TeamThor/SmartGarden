package com.company.gardens;

import com.company.DeciduousTree;
import com.company.Plant;
import com.company.Tree;

import java.util.ArrayList;

public class Orchard extends Garden implements TreeAddable,PlantDisplayable{

    public Orchard(String gardenName, GardenSize gardenSize) {
        super(gardenName,gardenSize);
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
            return String.format(" %s: Large Orchard Garden", this.getGardenName());
        }
        else{
            return this.getGardenSize()==GardenSize.MEDIUM?
                    String.format(" %s: Medium Orchard Garden", this.getGardenName()):
                    String.format(" %s: Small Orchard Garden", this.getGardenName());
        }
    }

}
