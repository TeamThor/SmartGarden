package com.company;

public class SingleFruit extends Fruit implements Waterable {
    public SingleFruit(String plantName, String plantingDate, int id) {
        super(plantName, plantingDate, id);
    }


    @Override
    public void water() {

    }
}

