package com.company;

import com.company.gardens.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            System.out.println("There is no such Garden");
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
            System.out.println("There is no such garden!");
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
            System.out.println("There is no such garden!");
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
            System.out.println("There is no such garden!");
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
            System.out.println("There is no such garden!");
        }
    }

    public void listPlants() {
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        boolean isValidGarden = false;
        do {
            if (gardens.size() < 1) {
                System.out.println("\nThere are no gardens yet!");
                System.out.println("You can create a garden by selecting the second option in the main menu!\n");
                break;
            }
            System.out.print("Enter Garden's Name: ");
            String gardenName = scan.nextLine();
            System.out.println();
            for (int i = 0; i < gardens.size(); i++) {
                if (gardens.get(i).getGardenName().equals(gardenName)) {
                    isValidGarden = true;

                    if ((gardens.get(i)).getPlantList().size() < 1) {
                        System.out.println("\nThere are no plants in this garden.\nYou can plant them by selecting the third option in the main menu.\n");
                        break;
                    } else {
                        if (gardens.get(i) instanceof PlantDisplayable) {
                            ((PlantDisplayable) gardens.get(i)).displayList();
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
        startApplication();
    }

    public void startApplication() {
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
                    listAllGardens();
                    break;
                case 5:
                    listPlants();
                    break;
                case 6:
                    maintainGarden();
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
                        createVineyardGarden(newGardenName, gSize);
                        break;
                    } catch (DuplicateGardenNameException e) {
                        System.out.println(e.getMessage());
                    }
                case 2:
                    try {
                        System.out.print("Enter the new gardens name: ");
                        String newGardenName = in.nextLine();
                        GardenSize gSize = checkIfValidSize();
                        createOrchardGarden(newGardenName, gSize);
                        break;
                    } catch (DuplicateGardenNameException e) {
                        System.out.println(e.getMessage());
                    }
                case 3:
                    try {
                        System.out.print("Enter the new gardens name: ");
                        String newGardenName = in.nextLine();
                        GardenSize gSize = checkIfValidSize();
                        createVegetableGarden(newGardenName, gSize);
                        break;
                    } catch (DuplicateGardenNameException e) {
                        System.out.println(e.getMessage());
                    }
                case 4:
                    try {
                        System.out.print("Enter the new gardens name: ");
                        String newGardenName = in.nextLine();
                        GardenSize gSize = checkIfValidSize();
                        createConiferousGarden(newGardenName, gSize);
                        break;
                    } catch (DuplicateGardenNameException e) {
                        System.out.println(e.getMessage());
                    }
                case 5:
                    try {
                        System.out.print("Enter the new gardens name: ");
                        String newGardenName = in.nextLine();
                        GardenSize gSize = checkIfValidSize();
                        createFruitGarden(newGardenName, gSize);
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

    private void listAllGardens() {
        if (gardens.size() < 1) {
            System.out.println("\nThere are no gardens yet!");
            System.out.println("You can create a garden by selecting the first option in the main menu!\n");
        } else {
            for (int i = 0; i < gardens.size(); i++) {
                System.out.println((i + 1) + ". " + gardens.get(i));
            }
        }
    }

    private void removeGardenMenu() {
        Scanner in = new Scanner(System.in);

        if (gardens.size() < 1) {
            System.out.println("\nThere are no gardens yet!");
            System.out.println("You can create a garden by selecting the first option in the main menu!\n");

        } else {
            listAllGardens();
            System.out.println((gardens.size() + 1) + ". Return to Main menu\n\n");
            int choice;
            while (true) {
                System.out.print("Enter the № of the garden you want to remove -> ");
                try {
                    choice = Integer.parseInt(in.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number!");
                    continue;
                }

                if (choice == gardens.size() + 1) {
                    break;
                } else if (choice <= 0 || choice > gardens.size() + 1) {
                    System.out.println("Garden with № " + choice + " doesn't exist!");
                } else {
                    System.out.println(gardens.get(choice - 1) + " has been removed.");
                    gardens.remove(choice - 1);
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
            if (gardens.size() < 1) {
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
                    System.out.print("Enter the planting date(DD.MM.YYYY) ->");
                    date = in.nextLine();
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
                    addDeciduousTree(gardenName, treeName, date, treeId, treeHeight);
                    break;
                case 2:
                    System.out.print("Enter the gardens name ->");
                    gardenName = in.nextLine();
                    System.out.print("Enter the trees name ->");
                    treeName = in.nextLine();
                    System.out.print("Enter the trees id ->");
                    treeId = Integer.parseInt(in.nextLine());
                    System.out.print("Enter the planting date(DD.MM.YYYY) ->");
                    date = in.nextLine();
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
                    addConiferousTree(gardenName, treeName, date, treeId, treeHeight);
                    break;
                case 3:
                    System.out.print("Enter the gardens name ->");
                    gardenName = in.nextLine();
                    System.out.print("Enter the fruit name ->");
                    treeName = in.nextLine();
                    System.out.print("Enter the trees id ->");
                    treeId = Integer.parseInt(in.nextLine());
                    System.out.print("Enter the planting date(DD.MM.YYYY) ->");
                    date = in.nextLine();
                    addFruit(gardenName, treeName, date, treeId);
                    break;
                case 4:
                    System.out.print("Enter the gardens name ->");
                    gardenName = in.nextLine();
                    System.out.print("Enter the Multiple Fruit name ->");
                    String multiFruitName = in.nextLine();
                    System.out.print("Enter the Multiple Fruit id ->");
                    int multiFruitId = Integer.parseInt(in.nextLine());
                    addGrapeVine(gardenName, multiFruitName, new SimpleDateFormat("dd.MM.yyyy").format(new Date())
                            , multiFruitId);
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

    private void maintainGarden() {
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
                            System.out.println("There are no plants in this garden");
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
