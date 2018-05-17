package com.company;

import com.company.gardens.*;
import com.company.menu.MainMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private ArrayList<Garden> gardens;

    private MainMenu menu;

    public ArrayList<Garden> getGardens() {
        return gardens;
    }

    public Application() {
        gardens = new ArrayList<>();
        this.menu = new MainMenu(this);

    }

    public void listAllGardens() {
        if (gardens.size() < 1) {
            System.out.println("\nThere are no gardens yet!");
            System.out.println("You can create a garden by selecting the first option in the main menu!\n");
        } else {
            for (int i = 0; i < gardens.size(); i++) {
                System.out.println((i + 1) + ". " + gardens.get(i));
            }
        }
    }

    public void listPlants() {
        Scanner scan = new Scanner(System.in);
        // int choice = 0;
        boolean isValidGarden = false;
        do {
            if (getGardens().size() < 1) {
                System.out.println("\nThere are no gardens yet!");
                System.out.println("You can create a garden by selecting the first option in the main menu!\n");
                break;
            }
            System.out.print("Enter Garden's Name: ");
            String gardenName = scan.nextLine();
            System.out.println();
            for (int i = 0; i < getGardens().size(); i++) {
                if (getGardens().get(i).getGardenName().equals(gardenName)) {
                    isValidGarden = true;

                    if ((getGardens().get(i)).getPlantList().size() < 1) {
                        System.out.println("\nThere are no plants in this garden.\nYou can plant them by selecting the third option in the main menu.\n");
                        break;
                    } else {
                        if (getGardens().get(i) instanceof PlantDisplayable) {
                            ((PlantDisplayable) getGardens().get(i)).displayList();
                            break;
                        }
                    }
                }
            }
            if (!isValidGarden) {
                System.out.println("Invalid Garden name!\nYou can check the existing gardens in the list below: \n");
                listAllGardens();
            }


        } while (!isValidGarden);
        menu.displayMenu();
    }


    public void createOrchardGarden(String name, GardenSize size) throws DuplicateGardenNameException {

        if (gardens.contains(new Orchard(name, size))) {
            throw new DuplicateGardenNameException("Garden with name " + name + " already exists.");
        } else {

            gardens.add(new Orchard(name, size));
            System.out.println(name + " was created.");

        }
    }

    public void createFruitGarden(String name, GardenSize size) throws DuplicateGardenNameException {

        if (gardens.contains(new FruitGarden(name, size))) {
            throw new DuplicateGardenNameException("\nGarden with name " + name + " already exists.");
        } else {

            gardens.add(new FruitGarden(name, size));
            System.out.println(name + " was created.");

        }
    }

    public void createConiferousGarden(String name, GardenSize size) throws DuplicateGardenNameException {

        if (gardens.contains(new ConiferousGarden(name, size))) {
            throw new DuplicateGardenNameException("\nGarden with name " + name + " already exists.");
        } else {
            gardens.add(new ConiferousGarden(name, size));
            System.out.println(name + " was created.");

        }
    }

    public void createVineyardGarden(String name, GardenSize size) throws DuplicateGardenNameException {
        if (gardens.contains(new Vineyard(name, size))) {
            throw new DuplicateGardenNameException("\nVineyard with name " + name + " already exists.");
        } else {
            gardens.add(new Vineyard(name, size));
            System.out.println(name + " was created.");
        }
    }

    public void createVegetableGarden(String name, GardenSize size) throws DuplicateGardenNameException {
        if (gardens.contains(new VeggieGarden(name, size))) {
            throw new DuplicateGardenNameException("\nVegetable garden with name " + name + "already exists.");
        } else {
            gardens.add(new VeggieGarden(name, size));
            System.out.printf("\nVegetable garden %s was created\n\n", name);
        }
    }

    public void addDeciduousTree(String gardenName, String treeName, String plantingDate, int id, TreeHeight height) {
        DeciduousTree myTree = new DeciduousTree(treeName, plantingDate, id, height);
        boolean isFound = false;
        for (int i = 0; i < gardens.size(); i++) {
            if (gardens.get(i).getGardenName().equals(gardenName)) {
                if (gardens.get(i) instanceof Orchard) {
                    gardens.get(i).addPlant(myTree);
                    System.out.println(treeName + " was added to " + gardenName);
                    isFound = true;
                } else {
                    System.out.println("You can add DeciduousTree only to Garden of type Orchard");
                    isFound = true;
                }
                break;
            }
        }
        if (!isFound) {
            System.out.println("There is no such Garden\nYou can check the existing gardens in the list below: \n");
            listAllGardens();

        }

    }

    public void addConiferousTree(String gardenName, String treeName, String plantingDate, int id, TreeHeight height) {
        ConiferousTree myTree = new ConiferousTree(treeName, plantingDate, id, height);
        boolean isConiferousGardenFound = false;
        for (int i = 0; i < gardens.size(); i++) {
            if (gardens.get(i).getGardenName().equals(gardenName)) {
                isConiferousGardenFound = true;
                if (gardens.get(i) instanceof ConiferousGarden) {
                    gardens.get(i).addPlant(myTree);
                    System.out.println(treeName + " was added to " + gardenName);
                    break;
                } else {
                    System.out.println("You can add ConiferousTree only to Garden of type ConiferousGarden");
                }
                break;
            }
        }
        if (!isConiferousGardenFound) {
            System.out.println("There is no such Garden\nYou can check the existing gardens in the list below: \n");
            listAllGardens();
        }

    }

    public void addFruit(String gardenName, String fruitName, String plantingDate, int id) {
        SingleFruit singleFruit = new SingleFruit(fruitName, plantingDate, id);
        boolean isFruitGardenFound = false;

        for (int i = 0; i < gardens.size(); i++) {
            if (gardens.get(i).getGardenName().equals(gardenName)) {
                isFruitGardenFound = true;
                if (gardens.get(i) instanceof FruitGarden) {
                    gardens.get(i).addPlant(singleFruit);
                    System.out.println(singleFruit + " was added to " + gardenName);
                } else {
                    System.out.println("You can add SingleFruit only to Garden of type Fruit Garden");
                }
                break;
            }
        }
        if (!isFruitGardenFound) {
            System.out.println("There is no such Garden\nYou can check the existing gardens in the list below: \n");
            listAllGardens();
        }

    }

    public void addGrapeVine(String gardenName, String vineName, String plantingDate, int id) {
        MultipleFruit newVine = new MultipleFruit(vineName, plantingDate, id);
        boolean isFruitGardenFound = false;
        for (Garden garden : gardens) {
            if (garden.getGardenName().equals(gardenName)) {
                isFruitGardenFound = true;
                if (garden instanceof Vineyard) {
                    garden.addPlant(newVine);
                    System.out.println(vineName + " was added to " + gardenName);
                    System.out.println();
                } else {
                    System.out.println("You can add grape vines only to Garden of type Vineyard");
                }
                break;
            }
        }
        if (!isFruitGardenFound) {
            System.out.println("There is no such Garden\nYou can check the existing gardens in the list below: \n");
            listAllGardens();
        }
    }

    public void addVegetable(String gardenName, String vegetableName, String plantingDate, int id) {
        Vegetable newVeggie = new Vegetable(vegetableName, plantingDate, id);
        boolean isVegetableGardenFound = false;
        for (Garden garden : gardens) {
            if (garden.getGardenName().equals(gardenName)) {
                isVegetableGardenFound = true;
                if (garden instanceof VeggieGarden) {
                    garden.addPlant(newVeggie);
                    System.out.printf("\n%s was added to the garden %s \n", vegetableName, gardenName);
                } else {
                    System.out.println("\nYou can only add vegetables to Vegetable garden!\n");
                }
                break;
            }
        }
        if (!isVegetableGardenFound) {
            System.out.println("There is no such Garden\nYou can check the existing gardens in the list below: \n");
            listAllGardens();
        }
    }


    public void maintainGarden() {
        Scanner in = new Scanner(System.in);

        while (true) {
            if (gardens.size() < 1) {
                System.out.println("\nThere are no gardens yet!");
                System.out.println("You can create a garden by selecting the first option in the main menu!\n");
                break;
            }

            System.out.print("Enter the name of the garden you wish to maintain ->\n");
            String gardenName = in.nextLine();
            if (gardens.contains(new Orchard(gardenName, GardenSize.LARGE))) {
                for (Garden garden : gardens) {
                    if (garden.getGardenName().equals(gardenName)) {
                        if (garden.getPlantList().size() == 0) {
                            System.out.println("\nThere are no plants in this garden.\nYou can plant them by selecting the third option in the main menu.\n");
                            break;
                        }
                        for (Plant plant : garden.getPlantList()) {
                            if (plant instanceof SingleFruit) {
                                ((SingleFruit) plant).water();
                            }
                            if (plant instanceof MultipleFruit) {
                                ((MultipleFruit) plant).spray();
                                ((MultipleFruit) plant).trim();
                            }
                            if (plant instanceof Vegetable) {
                                ((Vegetable) plant).water();
                            }
                            if (plant instanceof DeciduousTree) {
                                ((DeciduousTree) plant).harvest();
                                ((DeciduousTree) plant).trim();
                            }
                            if (plant instanceof ConiferousTree) {
                                ((ConiferousTree) plant).spray();
                            }
                        }
                    }
                }
                break;
            } else {
                System.out.println("\nThere isn't a garden with such name!");
                System.out.println("You can check the existing gardens in the list below: \n");
                listAllGardens();
            }
        }
    }
}
