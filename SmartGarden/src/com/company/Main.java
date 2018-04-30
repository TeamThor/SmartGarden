package com.company;

import com.company.gardens.GardenSize;

public class Main {

    public static void main(String[] args) {
        Application gardenApp = new Application();
        try {
            gardenApp.createGarden("Botanika",GardenSize.LARGE);
        } catch (DuplicateGardenNameException e) {
            e.printStackTrace();
        }
        try {
            gardenApp.createGarden("Botanika",GardenSize.LARGE);
        } catch (DuplicateGardenNameException e) {
            e.printStackTrace();
        }
    }
}
