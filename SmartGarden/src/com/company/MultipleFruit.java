package com.company;

import java.util.Date;
import java.text.SimpleDateFormat;

public class MultipleFruit extends Fruit implements Sprayable, Trimmable {
    private String sprayDate;
    private String trimDate;

    public MultipleFruit(String plantName, String plantingDate, int id) {
        super(plantName, plantingDate, id);
        sprayDate = "";
        trimDate = "";
    }

    @Override
    public void spray() {
        SimpleDateFormat ft =
                new SimpleDateFormat ("dd.MM.yyyy");
        sprayDate = ft.format(new Date());
        System.out.format("%s, id: %d, Spayed against pesticides at %s\n", getPlantName(), getId(), sprayDate);
    }

    @Override
    public void trim() {
        SimpleDateFormat ft =
                new SimpleDateFormat ("dd.MM.yyyy");
        trimDate = ft.format(new Date());;
        System.out.format("%s, id: %d, Trimmed at %s\n", getPlantName(), getId(), trimDate);
    }

    @Override
    public String toString() {
        return String.format("%s id:%d Planting Date:%s \n", getPlantName(), getId(), getPlantingDate());
    }


}
