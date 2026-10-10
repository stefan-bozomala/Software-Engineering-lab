package edu.tucn.aut.isp.lab4.exercise6;

public class TemperatureSensor extends Sensor {
    private float value;

    public TemperatureSensor(String manufacturer, String model, float value){
        super(manufacturer,model);
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
