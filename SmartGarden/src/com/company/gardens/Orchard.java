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
}
