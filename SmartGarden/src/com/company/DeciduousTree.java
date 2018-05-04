package com.company;

public class DeciduousTree extends Tree implements Trimmable, Harvestable {
    private String harvestDate;
    private String trimDate;

    public DeciduousTree(String plantName, String plantingDate, int id, TreeHeight height) {
        super(plantName, plantingDate, id, height);
        harvestDate = "";
        trimDate = "";
    }


    @Override
    public void harvest(String date) {
        harvestDate = date;
        System.out.format("%s, id: %d, Planting date: %s was harvest in %s\n",getPlantName(),getId(),getPlantingDate(),harvestDate);
    }

    @Override
    public void trim(String date) {
        trimDate = date;
        System.out.format("%s, id: %d, Planting date: %s was trimmed in %s\n",getPlantName(),getId(),getPlantingDate(),trimDate);
    }

    @Override
    public String toString() {
        if(harvestDate=="" && trimDate =="") {
            return super.toString();
        }
        else if(harvestDate!="" && trimDate==""){
            return super.toString() + " harvest date: "+harvestDate;
        }
        else if(trimDate!="" && harvestDate ==""){
            return super.toString() + ",trim date: " +trimDate;
        }
        else {
            return  super.toString() +" harvest date: "+harvestDate  + ",trim date: " +trimDate;
        }
    }
}
