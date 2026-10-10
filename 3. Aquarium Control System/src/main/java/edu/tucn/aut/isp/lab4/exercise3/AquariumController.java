package edu.tucn.aut.isp.lab4.exercise3;

import java.time.LocalTime;

public class AquariumController {
    //attributes
    private String manufacturer;
    private String model;
    private LocalTime currentTime;
    private LocalTime feedingTime; // = LocalTime.of(8, 0);

    private FishFeeder fishFeeder;

    //constructors
    public AquariumController(String manufacturer, String model){
        this.manufacturer = manufacturer;
        this.model = model;
        currentTime = LocalTime.now();
    }

    public AquariumController(FishFeeder fishFeeder){
        this.fishFeeder = fishFeeder; //agregare
    }

    public AquariumController(String manufacturer, String model, FishFeeder fishFeeder){
        this.manufacturer = manufacturer;
        this.model = model;
        currentTime = LocalTime.now();
        this.fishFeeder = fishFeeder;
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
    }

    @Override
    public String toString() {
        return "AquariumController{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", currentTime=" + currentTime +
                ", feedingTime=" + feedingTime +
                ", fishFeeder=" + fishFeeder +
                '}';
    }
}