package com.company;

import com.company.gardens.Garden;
import com.company.gardens.GardenSize;
import com.company.gardens.Orchard;
import com.company.gardens.Vineyard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Application {
    private HashSet<String> gardensNames;
    private ArrayList<Garden> gardens;

    public Application() {
        gardensNames = new HashSet<>();
        gardens = new ArrayList<>();
    }

    public void createOrchardGarden(String name, GardenSize size) throws DuplicateGardenNameException {

        if (gardens.contains(new Orchard(name, size))) {
            throw new DuplicateGardenNameException("Garden with name " + name + " already exists.");
        } else {
            gardensNames.add(name);
            gardens.add(new Orchard(name, GardenSize.LARGE));
            System.out.println(name + " was created.");

        }
    }

    public void createVineyardGarden(String name, GardenSize size) throws DuplicateGardenNameException {
        if (gardens.contains(new Vineyard(name, size))) {
            throw new DuplicateGardenNameException("Vineyard with name " + name + " already exists.");
        } else {
            gardensNames.add(name);
            gardens.add(new Vineyard(name, GardenSize.MEDIUM));
            System.out.println(name + " was created.");

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
                    System.out.println("You can add DeciduousTree only to Garden of type Orchad");
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
                        createVineyardGarden(newGardenName, GardenSize.MEDIUM);
                        break;
                    } catch (DuplicateGardenNameException e) {
                        e.getMessage();
                    }
                case 2:
                    try {
                        System.out.print("Enter the new gardens name: ");
                        String newGardenName = in.nextLine();
                        createOrchardGarden(newGardenName, GardenSize.LARGE);
                        break;
                    } catch (DuplicateGardenNameException e) {
                        e.getMessage();
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
            System.out.println((i + 1) + ". " + gardens.get(i).getGardenName());
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
            } else if (choice < 0 || choice >= gardens.size()) {
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
                "5. Vegetable",
                "6. Exit\n\n"};
        int choice = 0;
        do {
            System.out.print("Enter your choice -> ");
            choice = Integer.parseInt(in.nextLine());
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter the gardens name ->");
                    String gardenName = in.nextLine();
                    System.out.print("Enter the trees name ->");
                    String treeName = in.nextLine();
                    System.out.print("Enter the planting date(DD.MM.YYYY) ->");
                    String date = in.nextLine();
                    addDeciduousTree(gardenName, treeName, date, 1, TreeHeight.AVEARAGE);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
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
