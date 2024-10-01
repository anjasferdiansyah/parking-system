package com.enigmacamp.utils;

import com.enigmacamp.entity.ParkingLot;
import com.enigmacamp.service.ParkingLotService;
import com.enigmacamp.service.impl.ParkingLotServiceImpl;

import java.util.Scanner;

public class Menu {

    private static final ParkingLot parkingLot = new ParkingLot(6);
    private static final ParkingLotService parkingLotService = new ParkingLotServiceImpl(parkingLot);
    private static final Scanner scanner = new Scanner(System.in);

    public Menu() {

    }

    public  void menu (){
        while (true) {
            String input = scanner.nextLine();
            String[] commands = input.split(" ");

            switch (commands[0]) {
                case "create_parking_lot":
                    int slots = Integer.parseInt(commands[1]);
                    parkingLot.setTotalSlots(slots);
                    System.out.println("Created a parking lot with " + slots + " slots");
                    break;

                case "park":
                    if (parkingLot != null) {
                        String regNo = commands[1];
                        String color = commands[2];
                        String type = commands[3];
                        parkingLotService.parkVehicle(regNo, color, type);
                    }
                    break;

                case "leave":
                    if (parkingLot != null) {
                        int slotNo = Integer.parseInt(commands[1]);
                        parkingLotService.leaveVehicle(slotNo);
                    }
                    break;

                case "status":
                    if (parkingLot != null) {
                        parkingLotService.status();
                    }
                    break;

                case "type_of_vehicles":
                    if (parkingLot != null) {
                        String type = commands[1];
                        parkingLotService.countByType(type);
                    }
                    break;

                case "registration_numbers_for_vehicles_with_odd_plate":
                    if (parkingLot != null) {
                        parkingLotService.getVehicleRegNosByPlateType(true);
                    }
                    break;

                case "registration_numbers_for_vehicles_with_even_plate":
                    if (parkingLot != null) {
                        parkingLotService.getVehicleRegNosByPlateType(false);
                    }
                    break;

                case "registration_numbers_for_vehicles_with_colour":
                    if (parkingLot != null) {
                        String color = commands[1];
                        parkingLotService.getVehiclePlateNumberByColor(color);
                    }
                    break;

                case "slot_numbers_for_vehicles_with_colour":
                    if (parkingLot != null) {
                        String color = commands[1];
                        parkingLotService.getSlotNosByColor(color);
                    }
                    break;

                case "slot_number_for_registration_number":
                    if (parkingLot != null) {
                        String regNo = commands[1];
                        parkingLotService.getSlotNoByPlateNumber(regNo);
                    }
                    break;

                case "exit":
                    System.out.println("Exiting the system");
                    return;

                default:
                    System.out.println("Invalid command");
            }
        }
    }



}
