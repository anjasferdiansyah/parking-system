package com.enigmacamp.entity;

public class ParkingLot {
    private Integer totalSlots;
    private Vehicle[] slots;

    public ParkingLot(int totalSlots) {
        this.totalSlots = totalSlots;
        this.slots = new Vehicle[totalSlots];
    }

    public ParkingLot(){
    }

    public Vehicle[] getSlots() {
        return slots;
    }

    public void setSlots(Vehicle[] slots) {
        this.slots = slots;
    }

    public Integer getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(Integer totalSlots) {
        this.totalSlots = totalSlots;
    }

}
