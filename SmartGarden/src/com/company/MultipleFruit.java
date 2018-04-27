package com.company;

public class MultipleFruit extends Fruit implements Waterable, Sprayable, Trimmable {
    public MultipleFruit(String plantName, String plantingDate, int id) {
        super(plantName, plantingDate, id);
    }

    @Override
    public void water() {

    }

    @Override
    public void spray() {

    }

    @Override
    public void trim() {

    }
}
