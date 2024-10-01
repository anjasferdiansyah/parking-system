package com.enigmacamp.service;

import com.enigmacamp.entity.ParkingLot;

public interface ParkingLotService {
    public void parkVehicle(String regNo, String color, String type);
    public void leaveVehicle(int slotNumber);
    public void status();
    public void countByType(String type);
    public void getVehicleRegNosByPlateType(boolean isOdd);
    public void getVehiclePlateNumberByColor(String color);
    public void getSlotNosByColor(String color);
    public void getSlotNoByPlateNumber(String regNo);

}
