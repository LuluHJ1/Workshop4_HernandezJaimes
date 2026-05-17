package org.example;

import java.io.*;
import java.math.BigDecimal;

public class DealershipFileManager {
    public static final String filePath = "src/main/resources/Inventory.csv";
    public Dealership getDealership(){
        Dealership dealership = null;

        try(FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                //first line is dealership info
                String firstLine = bufferedReader.readLine();
            if(firstLine !=null)

                {
                    String[] contact = firstLine.split("\\|");
                    dealership = new Dealership(contact[0], contact[1], contact[2]);
                }

                //other lines are vehicles
                String input;

            while((input =bufferedReader.readLine())!=null)

                {
                    //if line is empty, skip it
                    if (input.trim().isEmpty()) {
                        continue;
                    }
                    String[] csvRow = input.split("\\|");

                    //if row doesn't have 8 values needed report it and move on
                    if (csvRow.length != 8) {
                        System.out.println("Invalid row format, expected 8 details" + input);
                        continue;
                    }
                    int vin = Integer.parseInt(csvRow[0]);
                    int year = Integer.parseInt(csvRow[1]);
                    String make = csvRow[2];
                    String model = csvRow[3];
                    String vehicleType = csvRow[4];
                    String color = csvRow[5];
                    int odometer = Integer.parseInt(csvRow[6]);
                    BigDecimal price = new BigDecimal(csvRow[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(vehicle);
                }
            }catch (IOException e) {
            System.out.println("There was a problem with the file.");
        }
        return dealership;
    }
    public void saveDealership(Dealership dealership){
        if(dealership == null){
            System.out.println("Cannot save.");
        }
        try(FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){

            //Write dealership header line
            bufferedWriter.write(dealership.getName() + "|" +  dealership.getAddress() + "|" + dealership.getPhone());
            bufferedWriter.newLine();

            //Write each vehicle
            for(Vehicle v : dealership.getAllVehicles()){
                bufferedWriter.write(
                        v.getVin() + "|" +
                                v.getYear() + "|" +
                                v.getMake() + "|" + v.getModel() + "|" +
                                v.getVehicleType() + "|" +
                                v.getColor() + "|" +
                                v.getOdometer() + "|" +
                                v.getPrice());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("There was a problem writing to file.");
        }
    }
}
