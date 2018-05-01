package com.company;

public class MultipleFruit extends Fruit implements Sprayable, Trimmable {
    private String sprayDate;
    private String trimDate;

    public MultipleFruit(String plantName, String plantingDate, int id) {
        super(plantName, plantingDate, id);
        sprayDate = "";
        trimDate = "";
    }

    @Override
    public void spray(String date) {
        sprayDate = date;
        System.out.format("%s, id: %d, Spayed against pesticides at %s", getPlantName(), getId(), sprayDate);
    }

    @Override
    public void trim(String date) {
        trimDate = date;
        System.out.format("%s, id: %d, Trimmed at %s", getPlantName(), getId(), trimDate);
    }
}
