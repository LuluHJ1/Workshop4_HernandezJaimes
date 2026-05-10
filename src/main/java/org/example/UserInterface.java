package org.example;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);
    private Dealership dealership;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
        init();
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();

        if(this.dealership == null){
            this.dealership = new Dealership();
        }
    }

    public void display() {
        boolean running = true;

        while (running) {
            System.out.println(ANSI_GREEN + "Dealership Menu");
            System.out.println("-------------------" + ANSI_RESET);
            System.out.println("1. Find vehicles within price range");
            System.out.println("2. Find vehicles by make/model");
            System.out.println("3. Find vehicles by year range");
            System.out.println("4. Find vehicles by color");
            System.out.println("5. Find vehicles by mileage range");
            System.out.println("6. Find vehicles by type (Truck, SUV, Sedan)");
            System.out.println("7. List All vehicles");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("99. Quit");
            System.out.println("Enter your choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        processGetByPriceRequest();
                        break;
                    case 2:
                        processGetByMakeModelRequest();
                        break;
                    case 3:
                        processGetByYearRequest();
                        break;
                    case 4:
                        processGetByColorRequest();
                        break;
                    case 5:
                        processGetByMileageRequest();
                        break;
                    case 6:
                        processGetByVehicleType();
                        break;
                    case 7:
                        processGetAllVehiclesRequest();
                        break;
                    case 8:
                        processAddVehicleRequest();
                        break;
                    case 9:
                        processRemoveVehicleRequest();
                        break;
                    case 99:
                        System.out.println(ANSI_GREEN + "Goodbye." + ANSI_RESET);
                        running = false;
                        break;

                    default:
                        System.out.println(ANSI_BLUE + "Invalid option" + ANSI_RESET);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_BLUE + "Not an option." + ANSI_RESET);
                scanner.nextLine();
            }
        }
    }

    public void processGetByPriceRequest() {
        System.out.println("Enter minimum: ");
        double min = scanner.nextDouble();
        System.out.println("Enter maximum: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        System.out.println(ANSI_GREEN + "Matching vehicles: ");
        System.out.println("----------------------" + ANSI_RESET);
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    public void processGetByMakeModelRequest() {
        System.out.println("Enter make: ");
        String make = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();

        System.out.println(ANSI_GREEN + "Matching vehicles: ");
        System.out.println("----------------------" + ANSI_RESET);
        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    public void processGetByYearRequest() {
        System.out.println("Enter minimum year: ");
        int min = scanner.nextInt();
        System.out.println("Enter maximum year: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        System.out.println(ANSI_GREEN + "Matching vehicles: ");
        System.out.println("----------------------" + ANSI_RESET);
        List<Vehicle> vehicles = dealership.getVehicleByYear(min, max);
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);

        }
    }

    public void processGetByColorRequest() {
        System.out.println("Enter color: ");
        String color = scanner.nextLine();

        System.out.println(ANSI_GREEN + "Matching vehicles: ");
        System.out.println("----------------------" + ANSI_RESET);
        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    public void processGetByMileageRequest() {
        System.out.println("Enter minimum mileage: ");
        int min = scanner.nextInt();
        System.out.println("Enter maximum mileage: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        System.out.println(ANSI_GREEN + "Matching vehicles: ");
        System.out.println("----------------------" + ANSI_RESET);
        List<Vehicle> vehicles = dealership.getVehiclesByMileage(min, max);
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    public void processGetByVehicleType() {
        System.out.println("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();

        System.out.println(ANSI_GREEN + "Matching vehicles: ");
        System.out.println("----------------------" + ANSI_RESET);
        List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    public void processGetAllVehiclesRequest() {

        System.out.println(ANSI_GREEN + "All vehicles: ");
        System.out.println("----------------------" + ANSI_RESET);
        List<Vehicle> vehicles = dealership.getAllVehicles();
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    public void processAddVehicleRequest() {
        System.out.println("Enter vin number: ");
        int vin = scanner.nextInt();
        System.out.println("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter make: ");
        String make = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();
        System.out.println("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();
        System.out.println("Enter color: ");
        String color = scanner.nextLine();
        System.out.println("Enter mileage: ");
        int odometer = scanner.nextInt();
        System.out.println("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(vehicle);

        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(this.dealership);
        System.out.println(ANSI_GREEN + "Vehicle added successfully." + ANSI_RESET);
    }

    public void processRemoveVehicleRequest() {
        System.out.println("Enter vin number: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        Vehicle vehicleToRemove = null;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                vehicleToRemove = vehicle;
                break;
            }
        }
        if (vehicleToRemove != null) {
            dealership.removeVehicle(vehicleToRemove);

            DealershipFileManager fileManager = new DealershipFileManager();
            fileManager.saveDealership(this.dealership);
            System.out.println(ANSI_GREEN + "Vehicle removed successfully." + ANSI_RESET);
        } else {
            System.out.println(ANSI_BLUE + "Vehicle with vin " + vin + " not found." + ANSI_RESET);
        }
    }
}

