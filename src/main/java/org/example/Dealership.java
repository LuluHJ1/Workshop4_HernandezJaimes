package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory;

    public Dealership() {
        this.inventory = new ArrayList<>();

    }
    public Dealership(String name, String address, String phone) {
        this();
        this.name = name;
        this.address = address;
        this.phone = phone;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }
    public List<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max){
        List<Vehicle> results = new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getPrice().compareTo(min) >= 0 && v.getPrice().compareTo(max) <= 0 ){
                results.add(v);
            }
        }
        return results;
    }
    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                results.add(v);
            }
        }
        return results;
    }
    public List<Vehicle> getVehicleByYear(int min, int max){
        List<Vehicle> results = new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getYear() >= min && v.getYear() <= max){
                results.add(v);
            }
        }
        return results;
    }
    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> results = new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getColor().equalsIgnoreCase(color)){
                results.add(v);
            }
        }
        return results;
    }
    public List<Vehicle> getVehiclesByMileage(int min, int max){
        List<Vehicle> results = new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getOdometer() >= min && v.getOdometer() <= max){
                results.add(v);
            }
        }
        return results;
    }
    public List<Vehicle> getVehiclesByType(String vehicleType){
        List<Vehicle> results = new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getVehicleType().equalsIgnoreCase(vehicleType)) {
                results.add(v);
            }
        }
        return results;
    }
    public List<Vehicle> getAllVehicles(){
        return inventory;
    }
}
