package isp.lab3.exercise3;

import isp.lab3.example.Car;

import java.util.Objects;

public class Vehicle {
    private String model;
    private String type;
    private int speed;
     public enum FuelType {B, D};
    private FuelType fuelType;

    public static int numberOfVehicles;

    public Vehicle(String m, String t, int s, FuelType f){
        model = m;
        type = t;
        speed = s;
        fuelType = f;
        numberOfVehicles++;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public String getModel() {
        return model;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getSpeed() {
        return speed;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }
    public FuelType getFuelType() {
        return fuelType;
    }

    @Override
    public String toString() {
        return model + " (" + type + ") " + "speed " + speed + " fuel type " + fuelType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Vehicle that = (Vehicle) obj;
        return speed == that.speed &&
                Objects.equals(model, that.model) &&
                Objects.equals(type, that.type) &&
                fuelType == that.fuelType;
    }
    @Override
    public int hashCode() {
        return Objects.hash(model, type, speed, fuelType);
    }

    public static void countVehicles(){
        System.out.println(numberOfVehicles);
    }
}