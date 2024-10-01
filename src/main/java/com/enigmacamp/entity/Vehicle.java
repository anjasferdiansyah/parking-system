package com.enigmacamp.entity;

public class Vehicle {
    private String plateNumber;
    private String color;
    private String model;

    public Vehicle(String plateNumber, String color, String model) {
        this.plateNumber = plateNumber;
        this.color = color;
        this.model = model;
    }

    public Vehicle() {
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
