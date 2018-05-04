package com.company;

public abstract class Tree extends Plant {
    private TreeHeight height;

    public Tree(String plantName, String plantingDate, int id, TreeHeight height) {
        super(plantName, plantingDate, id);
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("%s, id: %d, Planting Date: %s, height: %s",getPlantName(),getId(),getPlantingDate(),height);
    }
}
