package com.company;

import com.company.gardens.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private ArrayList<Garden> gardens;

    public Application() {
        gardens = new ArrayList<>();
    }

    public void createOrchardGarden(String name, GardenSize size) throws DuplicateGardenNameException {

        if (gardens.contains(new Orchard(name, size))) {
            throw new DuplicateGardenNameException("Garden with name " + name + " already exists.");
        } else {

            gardens.add(new Orchard(name, size));
            System.out.println(name + " was created.");

        }
    }

    public void createConiferousGarden(String name, GardenSize size) throws DuplicateGardenNameException {

        if (gardens.contains(new ConiferousGarden(name, size))) {
            throw new DuplicateGardenNameException("Garden with name " + name + " already exists.");
        } else {
            gardens.add(new ConiferousGarden(name, size));
            System.out.println(name + " was created.");

        }
    }

    public void createVineyardGarden(String name, GardenSize size) throws DuplicateGardenNameException {
        if (gardens.contains(new Vineyard(name, size))) {
            throw new DuplicateGardenNameException("Vineyard with name " + name + " already exists.");
        } else {
            gardens.add(new Vineyard(name, size));
            System.out.println(name + " was created.");
        }
    }

    public void createVegetableGarden(String name, GardenSize size) throws DuplicateGardenNameException {
        if (gardens.contains(new VeggieGarden(name, size))) {
            throw new DuplicateGardenNameException("Vegetable garden with name " + name + "already exists.");
        } else {
            gardens.add(new VeggieGarden(name, size));
            System.out.printf("Vegetable garden %s was created\n\n", name);
        }
    }


    public void addDeciduousTree(String gardenName, String treeName, String plantingDate, int id, TreeHeight height) {
        DeciduousTree myTree = new DeciduousTree(treeName, plantingDate, id, height);
        for (int i = 0; i < gardens.size(); i++) {
            if (gardens.get(i).getGardenName().equals(gardenName)) {
                if (gardens.get(i) instanceof Orchard) {
                    gardens.get(i).addPlant(myTree);
                    System.out.println(treeName + " was added to " + gardenName);
                } else {
                    System.out.println("You can add DeciduousTree only to Garden of type Orchard");
                }
                break;
            } else {
                System.out.println("There is no such Garden");
            }
        }

    }

    public void addGrapeVine(String gardenName, String vineName, String plantingDate, int id) {
        MultipleFruit newVine = new MultipleFruit(vineName, plantingDate, id);
        for (Garden garden : gardens) {
            if (garden.getGardenName().equals(gardenName)) {
                if (garden instanceof Vineyard) {
                    garden.addPlant(newVine);
                    System.out.println(vineName + " was added to " + gardenName);
                } else {
                    System.out.println("You can add grape vines only to Garden of type Vineyard");
                }
                break;
            } else {
                System.out.println("There is no such Garden");
            }
        }
    }

    public void addVegetable(String gardenName, String vegetableName, String plantingDate, int id) {
        Vegetable newVeggie = new Vegetable(vegetableName, plantingDate, id);
        for (Garden garden : gardens) {
            if (garden.getGardenName().equals(gardenName)) {
                if (garden instanceof VeggieGarden) {
                    garden.addPlant(newVeggie);
                    System.out.printf("\n%s was added to the garden %s \n", vegetableName, gardenName);
                } else {
                    System.out.println("\nYou can only add vegetables to Vegetable garden!\n");
                }
                break;
            } else {
                System.out.println("\nThere is no such Garden!\n");
            }
        }
    }


    public void startApplication() {
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
                    openCreateGardenMenu();
                    break;
                case 2:
                    removeGardenMenu();
                    break;
                case 3:
                    addPlantMenu();
                    break;
                case 4:
                    listAllGardens();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Not a valid choice");
                    break;
            }
        } while (choice != 5);
    }

    private void openCreateGardenMenu() {
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
                case 1:
                    try {
                        System.out.print("Enter the new gardens name: ");
                        String newGardenName = in.nextLine();
                        GardenSize gSize = GardenSize.SMALL;
                        boolean isValidSize = false;
                        do {
                            System.out.print("Enter garden size (SMALL, MEDIUM, LARGE): ");
                            String size = in.nextLine();

                            if (size.equalsIgnoreCase("MEDIUM")) {
                                gSize = GardenSize.MEDIUM;
                                isValidSize = true;
                                break;
                            } else if (size.equalsIgnoreCase("LARGE")) {
                                gSize = GardenSize.LARGE;
                                isValidSize = true;
                                break;
                            } else if (size.equalsIgnoreCase("SMALL")) {
                                gSize = GardenSize.SMALL;
                                isValidSize = true;
                                break;
                            } else {
                                System.out.println("Invalid size!\n");
                            }
                        } while (!isValidSize);
                        createVineyardGarden(newGardenName, gSize);
                        break;
                    } catch (DuplicateGardenNameException e) {
                        System.out.println(e.getMessage());
                    }
                case 2:
                    try {
                        System.out.print("Enter the new gardens name: ");
                        String newGardenName = in.nextLine();
                        GardenSize gSize = GardenSize.SMALL;
                        boolean isValidSize = false;
                        do {
                            System.out.print("Enter garden size (SMALL, MEDIUM, LARGE): ");
                            String size = in.nextLine();

                            if (size.equalsIgnoreCase("medium")) {
                                gSize = GardenSize.MEDIUM;
                                isValidSize = true;
                                break;
                            } else if (size.equalsIgnoreCase("large")) {
                                gSize = GardenSize.LARGE;
                                isValidSize = true;
                                break;
                            } else if (size.equalsIgnoreCase("SMALL")) {
                                gSize = GardenSize.SMALL;
                                isValidSize = true;
                                break;
                            } else {
                                System.out.println("Invalid size!\nPlease enter SMALL, MEDIUM or LARGE");
                            }
                        } while (!isValidSize);
                        createOrchardGarden(newGardenName, gSize);
                        break;
                    } catch (DuplicateGardenNameException e) {
                        System.out.println(e.getMessage());
                    }
                case 3:
                    try {
                        System.out.print("Enter the new gardens name: ");
                        String newGardenName = in.nextLine();
                        GardenSize gSize = GardenSize.SMALL;
                        boolean isValidSize = false;
                        do {
                            System.out.print("Enter garden size (SMALL, MEDIUM, LARGE): ");
                            String size = in.nextLine();

                            if (size.equalsIgnoreCase("medium")) {
                                gSize = GardenSize.MEDIUM;
                                isValidSize = true;
                                break;
                            } else if (size.equalsIgnoreCase("large")) {
                                gSize = GardenSize.LARGE;
                                isValidSize = true;
                                break;
                            } else if (size.equalsIgnoreCase("small")) {
                                gSize = GardenSize.SMALL;
                                isValidSize = true;
                                break;
                            } else {
                                System.out.println("Invalid size!\nPlease enter SMALL, MEDIUM or LARGE");
                            }
                        } while (!isValidSize);
                        createVegetableGarden(newGardenName, gSize);
                        break;
                    } catch (DuplicateGardenNameException e) {
                        System.out.println(e.getMessage());
                    }
                case 4:
                    try {
                        System.out.print("Enter the new gardens name: ");
                        String newGardenName = in.nextLine();
                        GardenSize gSize = GardenSize.SMALL;
                        boolean isValidSize = false;
                        do {
                            System.out.print("Enter garden size (SMALL, MEDIUM, LARGE): ");
                            String size = in.nextLine();

                            if (size.equalsIgnoreCase("medium")) {
                                gSize = GardenSize.MEDIUM;
                                isValidSize = true;
                                break;
                            } else if (size.equalsIgnoreCase("large")) {
                                gSize = GardenSize.LARGE;
                                isValidSize = true;
                                break;
                            } else if (size.equalsIgnoreCase("SMALL")) {
                                gSize = GardenSize.SMALL;
                                isValidSize = true;
                                break;
                            } else {
                                System.out.println("Invalid size!\nPlease enter SMALL, MEDIUM or LARGE");
                            }
                        } while (!isValidSize);
                        createConiferousGarden(newGardenName, gSize);
                        break;
                    } catch (DuplicateGardenNameException e) {
                        System.out.println(e.getMessage());
                    }
                case 5:
                    break;
                default:
                    System.out.println("Not a valid choice");
                    break;
            }
        } while (choice != 5);
    }

    private void listAllGardens() {
        for (int i = 0; i < gardens.size(); i++) {
            System.out.println((i + 1) + ". " + gardens.get(i));
        }
    }

    private void print10Lines() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    private void removeGardenMenu() {
        Scanner in = new Scanner(System.in);
        listAllGardens();
        System.out.println((gardens.size() + 1) + ". Return to Main menu\n\n");

        while (true) {
            System.out.print("Enter the No of the garden you want to remove -> ");
            int choice = Integer.parseInt(in.nextLine());
            System.out.println();

            if (choice == gardens.size() + 1) {
                break;
            } else if (choice <= 0 || choice > gardens.size() + 1) {
                System.out.println("Garden with No " + choice + " doesn't exist!");
            } else {
                System.out.println(gardens.get(choice - 1) + " has been removed.");
                gardens.remove(choice - 1);
                break;
            }
        }
    }

    private void addPlantMenu() {
        Scanner in = new Scanner(System.in);
        String[] optionsList = {"Add a:\n",
                "1. Deciduous tree\n",
                "2. Coniferous tree\n",
                "3. Single fruit plant\n",
                "4. Multiple fruit plant\n",
                "5. Vegetable\n",
                "6. Exit\n\n"};
        int choice = 0;
        do {
            for (String option : optionsList) {
                System.out.print(option);
            }
            System.out.print("Enter your choice -> ");
            choice = Integer.parseInt(in.nextLine());
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter the gardens name ->");
                    String gardenName = in.nextLine();
                    System.out.print("Enter the trees name ->");
                    String treeName = in.nextLine();
                    System.out.print("Enter the trees id ->");
                    int treeId = Integer.parseInt(in.nextLine());
                    System.out.print("Enter the planting date(DD.MM.YYYY) ->");
                    String date = in.nextLine();
                    addDeciduousTree(gardenName, treeName, date, treeId, TreeHeight.AVEARAGE);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.print("Enter the gardens name ->");
                    gardenName = in.nextLine();
                    System.out.print("Enter the vegetable name ->");
                    String vegetableName = in.nextLine();
                    System.out.print("Enter the vegetable id ->");
                    int vegetableId = Integer.parseInt(in.nextLine());
                    System.out.print("Enter the planting date(DD.MM.YYYY) ->");
                    date = in.nextLine();
                    addVegetable(gardenName, vegetableName, date, vegetableId);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Not a valid choice");
                    break;
            }
        } while (choice != 6);
    }
}
