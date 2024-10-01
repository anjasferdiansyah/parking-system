package com.enigmacamp.service;

import com.enigmacamp.entity.ParkingLot;

public interface ParkingLotService {
    void parkVehicle(String regNo, String color, String type);
    void leaveVehicle(int slotNumber);
    void status();
    void countByType(String type);
    void getVehicleRegNosByPlateType(boolean isOdd);
    void getVehiclePlateNumberByColor(String color);
    void getSlotNosByColor(String color);
    void getSlotNoByPlateNumber(String regNo);

}
