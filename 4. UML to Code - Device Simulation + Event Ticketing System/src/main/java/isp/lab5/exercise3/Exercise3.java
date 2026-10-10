package isp.lab5.exercise3;

import java.util.ArrayList;

public class Exercise3 {
    public static void main(String[] args) {

        ArrayList<Sensor> sensors = new ArrayList<Sensor>();
        MonitoringService monitoringService = new MonitoringService(sensors);

        System.out.println(monitoringService.getAverageAllSensors());
        System.out.println(monitoringService.getAverageTemperatureSensors());

        Sensor temperatureSensor = new TemperatureSensor("Acasa","Bosch1000",18.2);
        Sensor pressureSensor = new PressureSensor("Acasa","Bosch",1015);

        sensors.add(temperatureSensor);
        sensors.add(pressureSensor);

        System.out.println(monitoringService.getAverageAllSensors());
        System.out.println(monitoringService.getAverageTemperatureSensors());

    }
}