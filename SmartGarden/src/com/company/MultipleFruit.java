package com.company;

public class MultipleFruit extends Fruit implements Waterable, Sprayable, Trimmable {
    public MultipleFruit(String plantName, String plantingDate, int id) {
        super(plantName, plantingDate, id);
    }

     @Override
    public void spray(String date) {

    }

    @Override
    public void trim(String date) {

    }

    @Override
    public void water(String date) {

    }
}
