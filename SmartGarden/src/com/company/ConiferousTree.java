package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConiferousTree extends Tree implements Sprayable{
    private String sprayDate;
    public ConiferousTree(String plantName, String plantingDate, int id, TreeHeight height) {
        super(plantName, plantingDate, id, height);
        sprayDate = "";
    }

    @Override
    public void spray() {
        SimpleDateFormat ft =
                new SimpleDateFormat ("dd.MM.yyyy");
        sprayDate = ft.format(new Date());
        System.out.print(this + "was sprayed in "+sprayDate);
    }

    @Override
    public String toString() {
        if(sprayDate=="") {
            return super.toString();
        }
        else return super.toString() + "spray date: "+ sprayDate;
    }
}
