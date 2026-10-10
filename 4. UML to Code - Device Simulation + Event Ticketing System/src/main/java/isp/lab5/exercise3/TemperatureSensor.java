package isp.lab5.exercise3;

public class TemperatureSensor extends Sensor{
    private double temperature;
    private String type = "temperature";

    public TemperatureSensor(String installLocation, String name, double temperature) {
        super(installLocation, name);
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double getValue() {
        return temperature;
    }

    @Override
    public String toString() {
        return "TemperatureSensor{" +
                "temperature=" + temperature +
                '}';
    }
}
