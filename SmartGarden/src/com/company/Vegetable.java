package com.company;

import com.company.gardens.PlantDisplayable;

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
        System.out.format("%s, id: %d, Watered at %s\n", getPlantName(), getId(), waterDate);
    }


    @Override
    public String toString() {
            return String.format("%s id:%d Planting Date:%s \n", getPlantName(), getId(), getPlantingDate());
    }





}
