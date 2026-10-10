package isp.lab5.exercise3;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Exercise3Test {

    @Test
    public void testGetAverageTemperatureSensors() {
        ArrayList<Sensor> sensors = new ArrayList<Sensor>();
        MonitoringService monitoringService = new MonitoringService(sensors);

        //assertEquals(0.0,monitoringService.getAverageTemperatureSensors(),0.01);

        Sensor temperatureSensor = new TemperatureSensor("Acasa","Bosch1000",18.2);

        sensors.add(temperatureSensor);

        assertEquals(18.2,monitoringService.getAverageTemperatureSensors(),0.01);

    }

    @Test
    public void testGetAverageAllSensors() {
        ArrayList<Sensor> sensors = new ArrayList<Sensor>();
        MonitoringService monitoringService = new MonitoringService(sensors);

        Sensor temperatureSensor = new TemperatureSensor("Acasa","Bosch1000",18.2);
        Sensor pressureSensor = new PressureSensor("Acasa","Bosch",1015);

        sensors.add(temperatureSensor);
        sensors.add(pressureSensor);

        assertEquals(516.6,monitoringService.getAverageAllSensors(),0.01);

    }
}
