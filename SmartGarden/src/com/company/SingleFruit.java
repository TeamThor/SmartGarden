package com.company;

import java.util.Date;
import java.text.SimpleDateFormat;

public class SingleFruit extends Fruit implements Waterable {
    private String waterDate;

    public SingleFruit(String plantName, String date, int id) {
        super(plantName, date, id);
        waterDate = "";
    }
    @Override
    public void water() {
        SimpleDateFormat ft =
                new SimpleDateFormat ("dd.MM.yyyy");
        waterDate = ft.format(new Date());;
        System.out.println(getPlantName()+"was watered in "+waterDate);
    }

    @Override
    public String toString() {
        if (waterDate == "") {
            return String.format("%s id:%d Planting Date:%s\n", getPlantName(), getId(), getPlantingDate());
        } else
            return String.format("%s id:%d Planting Date:%s Last Water day: %s\n", getPlantName(), getId(), getPlantingDate(), waterDate);
    }

}

