package com.company;

public abstract class Plant {
    private String plantName;
    private String plantingDate;
    private int id;

    public Plant(String plantName, String plantingDate, int id) {
        this.plantName = plantName;
        this.plantingDate = plantingDate;
        this.id = id;
    }

    public void setPlantName(String plantName) {

        this.plantName = plantName;
    }

    public void setPlantingDate(String plantingDate) {

        this.plantingDate = plantingDate;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getPlantName() {

        return plantName;
    }

    public String getPlantingDate() {

        return plantingDate;
    }

    public int getId() {
        return id;
    }
}
