package org.example;

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
    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }
    public List<Vehicle> getVehiclesByPrice(double min, double max){
        return results;
    }
    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        return results;
    }
    public List<Vehicle> getVehicleByYear(int min, int max){
        return results;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        return results;
    }
    public List<Vehicle> getVehiclesByMileage(int min, int max){
        return results;
    }
    public List<Vehicle> getVehiclesByType(String vehicleType){
        return results;
    }
    public List<Vehicle> getAllVehicles(){
        return inventory;
    }
}
