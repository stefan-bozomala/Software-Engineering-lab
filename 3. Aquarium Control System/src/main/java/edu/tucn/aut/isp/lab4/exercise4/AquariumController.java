package edu.tucn.aut.isp.lab4.exercise4;

import java.time.LocalTime;

public class AquariumController {
    //attributes
    private String manufacturer;
    private String model;
    private LocalTime currentTime;
    private LocalTime feedingTime; // = LocalTime.of(8, 0);
    private FishFeeder fishFeeder;
    private Lights lights;

    private LocalTime lightOnTime;
    private LocalTime lightOffTime;

    //constructors
    public AquariumController(String manufacturer, String model, LocalTime feedingTime, FishFeeder fishFeeder, Lights lights, LocalTime lightOnTime, LocalTime lightOffTime){
        this.manufacturer = manufacturer;
        this.model = model;
        currentTime = LocalTime.now();
        this.feedingTime = feedingTime;
        this.fishFeeder = fishFeeder;
        this.lights = lights;
        this.lightOnTime = lightOnTime;
        this.lightOffTime = lightOffTime;
    }

    //methods

    public Lights getLights() {
        return lights;
    }

    public void setLights(Lights lights) {
        this.lights = lights;
    }

    public LocalTime getLightOffTime() {
        return lightOffTime;
    }

    public void setLightOffTime(LocalTime lightOffTime) {
        this.lightOffTime = lightOffTime;
    }

    public LocalTime getLightOnTime() {
        return lightOnTime;
    }

    public void setLightOnTime(LocalTime lightOnTime) {
        this.lightOnTime = lightOnTime;
    }

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

    public FishFeeder getFishFeeder() {
        return fishFeeder;
    }

    public void setFishFeeder(FishFeeder fishFeeder) {
        this.fishFeeder = fishFeeder;
    }

    public LocalTime getFeedingTime() {
        return feedingTime;
    }

    public void setFeedingTime(LocalTime feedingTime) {
        this.feedingTime = feedingTime;
        System.out.println("Feeding Time set");
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
        if (currentTime == feedingTime){
            fishFeeder.feed();
            System.out.println("Lunch time");
        }

        if (currentTime.isBefore(lightOnTime) || currentTime.isAfter(lightOffTime)) {
            lights.turnOff();
            System.out.println("Lights are off");
        } else if (currentTime.isAfter(lightOnTime) || currentTime.isBefore(lightOffTime)){
            lights.turnOn();
            System.out.println("Lights are on");
        }
    }

    @Override
    public String toString() {
        return "AquariumController{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", currentTime=" + currentTime +
                ", feedingTime=" + feedingTime +
                ", fishFeeder=" + fishFeeder +
                ", lights=" + lights +
                ", lightOnTime=" + lightOnTime +
                ", lightOffTime=" + lightOffTime +
                '}';
    }
}