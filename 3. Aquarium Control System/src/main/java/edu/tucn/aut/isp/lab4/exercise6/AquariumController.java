package edu.tucn.aut.isp.lab4.exercise6;

import java.time.LocalTime;

public class AquariumController {
    //attributes
    private FishFeeder fishFeeder;
    private String manufacturer;
    private String model;
    private LocalTime currentTime;
    private LocalTime feedingTime; // = LocalTime.of(8, 0);
    private int presetTemperature;
    private float presetLevel;
    private int presetPhLevel;

    private LevelSensor levelSensor = new LevelSensor("bosch","1",10);
    private TemperatureSensor temperatureSensor = new TemperatureSensor("bosch","a",20);
    private Actuator heater = new Heater("bosch", "1");
    private Actuator alarm = new Alarm("bosch","1");

    private PhSensor phSensor = new PhSensor("bosch","1",5);
    private Actuator phModifier = new PhModifier("bosch","c");

    //constructors
    public AquariumController(String manufacturer, String model, LocalTime feedingTime, FishFeeder fishFeeder, int presetTemperature, float presetLevel, int presetPhLevel){
        System.out.println("AquariumController created");
        this.fishFeeder = fishFeeder;
        this.manufacturer = manufacturer;
        this.model = model;
        currentTime = LocalTime.now();
        this.feedingTime = feedingTime;
        this.presetTemperature = presetTemperature;
        this.presetLevel = presetLevel;
        this.presetPhLevel = presetPhLevel;
    }

    //methods
    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
        if (currentTime == feedingTime){
            fishFeeder.feed();
            System.out.println("Lunch time");
        }

    }

    public void setFeedingTime(LocalTime feedingTime) {
        this.feedingTime = feedingTime;
        System.out.println("Feeding Time set");
    }

    public void checkTemperature(){
       if (temperatureSensor.getValue() < presetTemperature) heater.turnOn();
       else if (temperatureSensor.getValue() == presetTemperature) heater.turnOff();
    }

    public void checkPhLevel(){
        if (phSensor.getValue() < presetPhLevel) phModifier.turnOn();
        else phModifier.turnOff();
    }

    public void checkWaterLevel(){
        if(levelSensor.getValue() < presetLevel){
            alarm.turnOn();
        }
        else alarm.turnOff();
    }

    @Override
    public String toString() {
        return "AquariumController{" +
                "fishFeeder=" + fishFeeder +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", currentTime=" + currentTime +
                ", feedingTime=" + feedingTime +
                ", presetTemperature=" + presetTemperature +
                ", presetLevel=" + presetLevel +
                ", presetPhLevel=" + presetPhLevel +
                ", levelSensor=" + levelSensor +
                ", temperatureSensor=" + temperatureSensor +
                ", heater=" + heater +
                ", alarm=" + alarm +
                ", phSensor=" + phSensor +
                ", phModifier=" + phModifier +
                '}';
    }

    public FishFeeder getFishFeeder() {
        return fishFeeder;
    }

    public void setFishFeeder(FishFeeder fishFeeder) {
        this.fishFeeder = fishFeeder;
    }

    public float getPresetLevel() {
        return presetLevel;
    }

    public void setPresetLevel(float presetLevel) {
        this.presetLevel = presetLevel;
    }

    public int getPresetTemperature() {
        return presetTemperature;
    }

    public void setPresetTemperature(int presetTemperature) {
        this.presetTemperature = presetTemperature;
    }

    public LocalTime getFeedingTime() {
        return feedingTime;
    }

    public LocalTime getCurrentTime() {
        return currentTime;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public LevelSensor getLevelSensor() {
        return levelSensor;
    }

    public void setLevelSensor(LevelSensor levelSensor) {
        this.levelSensor = levelSensor;
    }

    public Actuator getAlarm() {
        return alarm;
    }

    public void setAlarm(Actuator alarm) {
        this.alarm = alarm;
    }

    public Actuator getHeater() {
        return heater;
    }

    public void setHeater(Actuator heater) {
        this.heater = heater;
    }

    public TemperatureSensor getTemperatureSensor() {
        return temperatureSensor;
    }

    public void setTemperatureSensor(TemperatureSensor temperatureSensor) {
        this.temperatureSensor = temperatureSensor;
    }

    public int getPresetPhLevel() {
        return presetPhLevel;
    }

    public void setPresetPhLevel(int presetPhLevel) {
        this.presetPhLevel = presetPhLevel;
    }

    public Actuator getPhModifier() {
        return phModifier;
    }

    public void setPhModifier(Actuator phModifier) {
        this.phModifier = phModifier;
    }

    public PhSensor getPhSensor() {
        return phSensor;
    }

    public void setPhSensor(PhSensor phSensor) {
        this.phSensor = phSensor;
    }
}