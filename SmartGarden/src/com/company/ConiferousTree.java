package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConiferousTree extends Tree implements Sprayable{
    private String sprayDate;
    public ConiferousTree(String plantName, String date, int id, TreeHeight height) {
        super(plantName, date, id, height);
        sprayDate = "";
    }

    @Override
    public void spray() {
        SimpleDateFormat ft =
                new SimpleDateFormat ("dd.MM.yyyy");
        sprayDate = ft.format(new Date());
        System.out.print(this + "was sprayed in "+sprayDate);
        System.out.println();
    }

    @Override
    public String toString() {
        if(sprayDate.equals("")) {
            return super.toString();
        }
        else return super.toString() + "spray date: "+ sprayDate;
    }
}
