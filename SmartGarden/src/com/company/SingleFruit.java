package com.company;

public class SingleFruit extends Fruit implements Waterable {
    private String waterDate;

    public SingleFruit(String plantName, String plantingDate, int id) {
        super(plantName, plantingDate, id);
        waterDate = "";
    }
    @Override
    public void water(String date) {
        waterDate = date;
        System.out.println(getPlantName()+"was watered in "+date);
    }

    @Override
    public String toString() {
        if (waterDate == "") {
            return String.format("%s id:%d Planting Date:%s", getPlantName(), getId(), getPlantingDate());
        } else
            return String.format("%s id:%d Planting Date:%s Last Water day: %s", getPlantName(), getId(), getPlantingDate(), waterDate);
    }

}

