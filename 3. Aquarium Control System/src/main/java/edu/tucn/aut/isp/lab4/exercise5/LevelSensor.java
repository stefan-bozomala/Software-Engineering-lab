package edu.tucn.aut.isp.lab4.exercise5;

public class LevelSensor extends Sensor {
    private int value;

    public LevelSensor(String manufacturer, String model, int value){
        super(manufacturer, model);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
