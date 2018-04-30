package com.company;

import com.company.gardens.Garden;
import com.company.gardens.GardenSize;

import java.util.HashSet;

public class Application {
    HashSet<String> gardensNames;
    public Application(){
        gardensNames = new HashSet<>();
    }

    public void createGarden(String name, GardenSize size) throws DuplicateGardenNameException {
        if (gardensNames.contains(name)) {
            throw new DuplicateGardenNameException("Garden with name " + name + " already exists.");
        } else {
            gardensNames.add(name);
            System.out.println(name + " was created.");

        }

    }
}
