package edu.tucn.aut.isp.lab4.exercise6;

public class Actuator {

    private String manufacturer;
    private String model;
    private boolean on = false;

    public Actuator(String manufacturer, String model){
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public void turnOn(){
        on = true;
        System.out.println("Actuator turn on");
    }

    public void turnOff(){
        on = false;
        System.out.println("Actuator turn off");
    }

    @Override
    public String toString() {
        return "Actuator{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", on=" + on +
                '}';
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
