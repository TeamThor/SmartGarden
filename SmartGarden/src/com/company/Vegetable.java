package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Vegetable extends Plant implements Waterable {
    private String waterDate;

    public Vegetable(String plantName, String plantingDate, int id) {
        super(plantName, plantingDate, id);
        waterDate = "";
    }

    @Override
    public void water() {
        SimpleDateFormat ft =
                new SimpleDateFormat ("dd.MM.yyyy");
        waterDate = ft.format(new Date());
        System.out.format("%s, id: %d, Watered at %s", getPlantName(), getId(), waterDate);
    }
}
