package edu.tucn.aut.isp.lab4.exercise1;

import java.time.LocalTime;

public class AquariumController {
    //attributes
    private String manufacturer;
    private String model;
    private LocalTime currentTime;

    //constructors
    public AquariumController(String manufacturer, String model){
        this.manufacturer = manufacturer;
        this.model = model;
        currentTime = LocalTime.now();
    }

    //methods
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public String toString() {
        return "AquariumController{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", currentTime=" + currentTime +
                '}';
    }
}
