package com.company;

public class Vegetable extends Plant implements Waterable {
    private String waterDate;

    public Vegetable(String plantName, String plantingDate, int id) {
        super(plantName, plantingDate, id);
        waterDate = "";
    }

    @Override
    public void water(String date) {
        waterDate = date;
        System.out.format("%s, id: %d, Watered at %s", getPlantName(), getId(), waterDate);
    }
}
