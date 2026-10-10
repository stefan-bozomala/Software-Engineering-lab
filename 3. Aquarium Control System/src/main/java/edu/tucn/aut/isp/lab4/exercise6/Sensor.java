package edu.tucn.aut.isp.lab4.exercise6;

public class Sensor {

    private String manufacturer;
    private String model;

    public Sensor(String manufacturer, String model){
        this.manufacturer = manufacturer;
        this.model=model;
    };

    @Override
    public String toString() {
        return "Sensor{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
