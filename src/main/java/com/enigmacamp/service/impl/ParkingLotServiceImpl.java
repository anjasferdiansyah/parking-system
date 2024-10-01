package com.enigmacamp.service.impl;

import com.enigmacamp.entity.ParkingLot;
import com.enigmacamp.entity.Vehicle;
import com.enigmacamp.service.ParkingLotService;

public class ParkingLotServiceImpl implements ParkingLotService {

    private final ParkingLot parkingLot;


    public ParkingLotServiceImpl(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }



    @Override
    public void parkVehicle(String regNo, String color, String type) {
        for (int i = 0; i < parkingLot.getTotalSlots(); i++) {
            if (parkingLot.getSlots()[i] == null) {
                parkingLot.getSlots()[i] = new Vehicle(regNo, color, type);
                System.out.println("Allocated slot number: " + (i + 1));
                return;
            }
        }
        System.out.println("Sorry parking lot is full");
    }

    @Override
    public void leaveVehicle(int slotNumber) {
        if (slotNumber > 0 && slotNumber <= parkingLot.getTotalSlots() && parkingLot.getSlots()[slotNumber - 1] != null) {
            parkingLot.getSlots()[slotNumber - 1] = null;
            System.out.println("Slot number " + slotNumber + " is free");
        } else {
            System.out.println("Slot is already empty or invalid slot number.");
        }
    }

    @Override
    public void status() {
        System.out.println("Slot\tNo.\t\tType\tColor");
        for (int i = 0; i < parkingLot.getTotalSlots(); i++) {
            if (parkingLot.getSlots()[i] != null) {
                System.out.println((i + 1) + "\t" + parkingLot.getSlots()[i].getPlateNumber() + "\t" + parkingLot.getSlots()[i].getModel() + "\t" + parkingLot.getSlots()[i].getColor());
            }
        }
    }

    @Override
    public void countByType(String type) {
        int count = 0;
        for (Vehicle vehicle : parkingLot.getSlots()) {
            if (vehicle != null && vehicle.getModel().equalsIgnoreCase(type)) {
                count++;
            }
        }
        System.out.println(count);
    }

    @Override
    public void getVehicleRegNosByPlateType(boolean isOdd) {
        for (Vehicle vehicle : parkingLot.getSlots()) {
            if (vehicle != null) {
                String[] regParts = vehicle.getPlateNumber().split("-");
                int numberPart = Integer.parseInt(regParts[1]);
                if ((isOdd && numberPart % 2 != 0) || (!isOdd && numberPart % 2 == 0)) {
                    System.out.print(vehicle.getPlateNumber() + " ");
                }
            }
            System.out.println();
        }


    }

    @Override
    public void getSlotNosByColor(String color) {
        for (int i = 0; i < parkingLot.getTotalSlots(); i++) {
            if (parkingLot.getSlots()[i] != null && parkingLot.getSlots()[i].getColor().equalsIgnoreCase(color)) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }

    @Override
    public void getVehiclePlateNumberByColor(String color) {
        for (Vehicle vehicle : parkingLot.getSlots()) {
            if (vehicle != null && vehicle.getColor().equalsIgnoreCase(color)) {
                System.out.print(vehicle.getPlateNumber() + " ");
            }
        }
        System.out.println();
    }

    @Override
    public void getSlotNoByPlateNumber(String regNo) {
        for (int i = 0; i < parkingLot.getTotalSlots(); i++) {
            if (parkingLot.getSlots()[i] != null && parkingLot.getSlots()[i].getPlateNumber().equalsIgnoreCase(regNo)) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println("Not found");
    }
    }