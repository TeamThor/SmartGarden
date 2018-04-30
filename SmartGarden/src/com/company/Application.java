package com.company;

import com.company.gardens.Garden;
import com.company.gardens.GardenSize;
import com.company.gardens.Orchard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Application {
    HashSet<String> gardensNames;
    ArrayList<Garden> gardens;
    public Application(){
        gardensNames = new HashSet<>();
        gardens = new ArrayList<>();
    }

    public void createOrchardGarden(String name, GardenSize size) throws DuplicateGardenNameException {

        if (gardens.contains(new Orchard(name, size))) {
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


    public void startApplication(){
        Scanner in = new Scanner(System.in);
        int choice = 0;

        String[] optionsList = {"Main Menu:\n",
            "1. Create a new garden\n",
            "2. Delete an existing garden\n",
            "3. Add a plant to an existing garden\n",
            "4. List all gardens\n",
            "5. Exit\n\n",
            "Enter you choice -> "};
        do {

            for (String option : optionsList) {
                System.out.print(option);
            }

            choice = Integer.parseInt(in.nextLine());

            switch (choice) {
                case 1:
                    openGardenMenu();
                    break;
                case 5:
                    break;
            }
        }while (choice!=5);
        return;
    }

    private void openGardenMenu(){
        Scanner in = new Scanner(System.in);
        int choice = 0;

        String[] optionsList = {"Create Garden:\n",
                "1. Create a new Vineyard garden\n",
                "2. Create a new Orchard garden\n",
                "3. Create a new Vegetable garden\n",
                "4. Create a new Coniferous garden\n",
                "5. Return to Main menu\n\n",
                "Enter you choice -> "};

        do {
            for (String option : optionsList) {
                System.out.print(option);
            }
            choice = Integer.parseInt(in.nextLine());
            System.out.println();

            switch (choice) {
                case 2:
                    try {
                        System.out.print("Enter the new gardens name: ");
                        String newGardenName = in.nextLine();
                        createOrchardGarden(newGardenName, GardenSize.LARGE);
                        break;
                    } catch (DuplicateGardenNameException e) {
                        e.getMessage();
                    }
                case 5: break;
            }
        }while (choice!=5);

        return;
    }
}
