package com.company.menu;

import com.company.Application;
import com.company.DuplicateGardenNameException;
import com.company.TreeHeight;
import com.company.gardens.GardenSize;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {


    private Application app;

    public MainMenu(Application app) {
        this.app = app;
    }

    public void displayMenu() {
        Scanner in = new Scanner(System.in);
        int choice = 0;

        String[] optionsList = {"Main Menu:\n",
                "1. Create a new garden\n",
                "2. Delete an existing garden\n",
                "3. Add a plant to an existing garden\n",
                "4. List all gardens\n",
                "5. List plants of a given garden\n",
                "6. Garden maintenance\n",
                "7. Exit\n\n",
                "Enter you choice -> \n"};
        do {

            for (String option : optionsList) {
                System.out.print(option);
            }

            try {
                choice = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
                continue;
            }

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
                    app.listAllGardens();
                    break;
                case 5:
                    app.listPlants();
                    break;
                case 6:
                    app.maintainGarden();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Not a valid choice");
                    break;
            }
        } while (choice != 7);
    }

    private void openCreateGardenMenu() {
        Scanner in = new Scanner(System.in);
        int choice = 0;

        String[] optionsList = {"Create Garden:\n",
                "1. Create a new Vineyard garden\n",
                "2. Create a new Orchard garden\n",
                "3. Create a new Vegetable garden\n",
                "4. Create a new Coniferous garden\n",
                "5. Create a new Fruit garden\n",
                "6. Return to Main menu\n\n",
                "Enter you choice -> "};

        do {
            for (String option : optionsList) {
                System.out.print(option);
            }
            try {
                choice = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter the new gardens name: ");
                        String newGardenName = in.nextLine();
                        GardenSize gSize = checkIfValidSize();
                        app.createVineyardGarden(newGardenName, gSize);
                        break;
                    } catch (DuplicateGardenNameException e) {
                        System.out.println(e.getMessage());
                    }
                case 2:
                    try {
                        System.out.print("Enter the new gardens name: ");
                        String newGardenName = in.nextLine();
                        GardenSize gSize = checkIfValidSize();
                        app.createOrchardGarden(newGardenName, gSize);
                        break;
                    } catch (DuplicateGardenNameException e) {
                        System.out.println(e.getMessage());
                    }
                case 3:
                    try {
                        System.out.print("Enter the new gardens name: ");
                        String newGardenName = in.nextLine();
                        GardenSize gSize = checkIfValidSize();
                        app.createVegetableGarden(newGardenName, gSize);
                        break;
                    } catch (DuplicateGardenNameException e) {
                        System.out.println(e.getMessage());
                    }
                case 4:
                    try {
                        System.out.print("Enter the new gardens name: ");
                        String newGardenName = in.nextLine();
                        GardenSize gSize = checkIfValidSize();
                        app.createConiferousGarden(newGardenName, gSize);
                        break;
                    } catch (DuplicateGardenNameException e) {
                        System.out.println(e.getMessage());
                    }
                case 5:
                    try {
                        System.out.print("Enter the new gardens name: ");
                        String newGardenName = in.nextLine();
                        GardenSize gSize = checkIfValidSize();
                        app.createFruitGarden(newGardenName, gSize);
                        break;
                    } catch (DuplicateGardenNameException e) {
                        System.out.println(e.getMessage());
                    }
                case 6:
                    break;
                default:
                    System.out.println("Not a valid choice");
                    break;
            }
        } while (choice != 6);
    }


    private void removeGardenMenu() {
        Scanner in = new Scanner(System.in);

        if (app.getGardens().size() < 1) {
            System.out.println("\nThere are no gardens yet!");
            System.out.println("You can create a garden by selecting the first option in the main menu!\n");

        } else {
            app.listAllGardens();
            System.out.println((app.getGardens().size() + 1) + ". Return to Main menu\n");
            int choice;
            while (true) {
                System.out.print("Please select an option from the above -> \n");
                try {
                    choice = Integer.parseInt(in.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number!");
                    continue;
                }

                if (choice == app.getGardens().size() + 1) {
                    break;
                } else if (choice <= 0 || choice > app.getGardens().size() + 1) {
                    System.out.println("Garden with № " + choice + " doesn't exist!");
                } else {
                    System.out.println(app.getGardens().get(choice - 1) + " has been removed.");
                    app.getGardens().remove(choice - 1);
                    break;
                }
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
            if (app.getGardens().size() < 1) {
                System.out.println("\nThere are no gardens yet!");
                System.out.println("You can create a garden by selecting the first option in the main menu!\n");
                break;
            }
            for (String option : optionsList) {
                System.out.print(option);
            }
            System.out.print("Enter your choice -> ");
            try {
                choice = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
                continue;
            }
            String gardenName = "";
            String treeName = "";
            int treeId = 0;
            String date = "";
            TreeHeight treeHeight = TreeHeight.SHORT;

            String height = "";
            switch (choice) {
                case 1:
                    System.out.print("Enter the gardens name ->");
                    gardenName = in.nextLine();
                    System.out.print("Enter the trees name ->");
                    treeName = in.nextLine();
                    System.out.print("Enter the trees id ->");
                    treeId = Integer.parseInt(in.nextLine());
                    boolean isValidHeight = false;
                    do {
                        System.out.print("Enter tree height (SHORT, AVERAGE, HIGH) :  ");
                        height = in.nextLine();
                        if (height.equalsIgnoreCase("short")) {
                            treeHeight = TreeHeight.SHORT;
                            isValidHeight = true;
                            break;
                        } else if (height.equalsIgnoreCase("average")) {
                            treeHeight = TreeHeight.AVERAGE;
                            isValidHeight = true;
                            break;
                        } else if (height.equalsIgnoreCase("High")) {
                            treeHeight = TreeHeight.HIGH;
                            isValidHeight = true;
                            break;
                        } else {
                            System.out.println("Invalid height!\n");
                        }
                    } while (!isValidHeight);
                    app.addDeciduousTree(gardenName, treeName, date, treeId, treeHeight);
                    break;
                case 2:
                    System.out.print("Enter the gardens name ->");
                    gardenName = in.nextLine();
                    System.out.print("Enter the trees name ->");
                    treeName = in.nextLine();
                    System.out.print("Enter the trees id ->");
                    treeId = Integer.parseInt(in.nextLine());
                    boolean isValidHeight2 = false;
                    do {
                        System.out.print("Enter tree height (SHORT, AVERAGE, HIGH) :  ");
                        height = in.nextLine();
                        if (height.equalsIgnoreCase("short")) {
                            treeHeight = TreeHeight.SHORT;
                            isValidHeight2 = true;
                            break;
                        } else if (height.equalsIgnoreCase("average")) {
                            treeHeight = TreeHeight.AVERAGE;
                            isValidHeight2 = true;
                            break;
                        } else if (height.equalsIgnoreCase("High")) {
                            treeHeight = TreeHeight.HIGH;
                            isValidHeight2 = true;
                            break;
                        } else {
                            System.out.println("Invalid height!\n");
                        }
                    } while (!isValidHeight2);
                    app.addConiferousTree(gardenName, treeName, date, treeId, treeHeight);
                    break;
                case 3:
                    System.out.print("Enter the gardens name ->");
                    gardenName = in.nextLine();
                    System.out.print("Enter the fruit name ->");
                    treeName = in.nextLine();
                    System.out.print("Enter the trees id ->");
                    treeId = Integer.parseInt(in.nextLine());
                    app.addFruit(gardenName, treeName, new SimpleDateFormat("dd.MM.yyyy").format(new Date()), treeId);
                    break;
                case 4:
                    System.out.print("Enter the gardens name ->");
                    gardenName = in.nextLine();
                    System.out.print("Enter the Multiple Fruit name ->");
                    String multiFruitName = in.nextLine();
                    System.out.print("Enter the Multiple Fruit id ->");
                    int multiFruitId = Integer.parseInt(in.nextLine());
                    app.addGrapeVine(gardenName, multiFruitName, new SimpleDateFormat("dd.MM.yyyy").format(new Date())
                            , multiFruitId);
                    break;
                case 5:
                    System.out.print("Enter the gardens name ->");
                    gardenName = in.nextLine();

                    System.out.print("Enter the vegetable name ->");
                    String vegetableName = in.nextLine();

                    System.out.print("Enter the vegetable id ->");
                    int vegetableId = 0;
                    boolean isNotValidNumber = true;
                    while (isNotValidNumber) {
                        isNotValidNumber = false;
                        try {
                            vegetableId = Integer.parseInt(in.nextLine());
                        } catch (NumberFormatException e) {
                            isNotValidNumber = true;
                            System.out.println("Please enter a number! ->");
                        }
                    }
                    app.addVegetable(gardenName, vegetableName, new SimpleDateFormat("dd.MM.yyyy").format(new Date()), vegetableId);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Not a valid choice\n");
                    break;
            }
        } while (choice != 6);
    }

    private GardenSize checkIfValidSize() {
        Scanner in = new Scanner(System.in);
        GardenSize gSize = null;
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
                System.out.println("Invalid size!\nPlease enter SMALL, MEDIUM or LARGE\n");
            }
        } while (!isValidSize);
        return gSize;
    }
}
