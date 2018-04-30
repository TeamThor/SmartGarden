package com.company;

import com.company.gardens.Garden;
import com.company.gardens.GardenSize;
import com.company.gardens.Orchard;

import java.util.ArrayList;
import java.util.HashSet;

public class Application {
    HashSet<String> gardensNames;
    ArrayList<Garden> gardens;
    public Application(){
        gardensNames = new HashSet<>();
        gardens = new ArrayList<>();
    }

    public void createOrchardGarden(String name, GardenSize size) throws DuplicateGardenNameException {

        if (gardens.contains(name)) {
            throw new DuplicateGardenNameException("Garden with name " + name + " already exists.");
        } else {
            gardensNames.add(name);
            gardens.add(new Orchard(name,GardenSize.LARGE));
            System.out.println(name + " was created.");

        }
    }

    public void addDeciduousTree(String gardenName, String treeName, String plantingDate, int id, TreeHeight height){
        DeciduousTree myTree = new DeciduousTree(treeName,plantingDate,id,height);
        for(int i =0;i<gardens.size();i++){
            if(gardens.get(i).getGardenName().equals(gardenName)){
                if(gardens.get(i) instanceof Orchard){
                gardens.get(i).addPlant(myTree);
                    System.out.println(treeName+" was added to "+gardenName);}
                else {
                    System.out.println("You can add DeciduousTree only to Garden of type Orchad");
                }
                break;
            }
            else{
                System.out.println("There is no such Garden");
            }
        }

    }
}
