package edu.tucn.aut.isp.lab4.exercise5;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AquariumControllerTest {

    AquariumController aquariumController = new AquariumController("bosch", "1", LocalTime.of(8, 0, 0), new FishFeeder("bosch", "1"), 26, 15);

    @Test
    void checkTemperature() {
        aquariumController.getTemperatureSensor().setValue(26);
        aquariumController.checkTemperature(); //20
        assertEquals(false, aquariumController.getHeater().isOn());

        aquariumController.getTemperatureSensor().setValue(20);
        aquariumController.checkTemperature(); //20
        assertEquals(true, aquariumController.getHeater().isOn());
    }

    @Test
    void checkWaterLevel(){
        aquariumController.getLevelSensor().setValue(10);
        aquariumController.checkWaterLevel();
        assertEquals(true, aquariumController.getAlarm().isOn());

        aquariumController.getLevelSensor().setValue(15);
        aquariumController.checkWaterLevel();
        assertEquals(false, aquariumController.getAlarm().isOn());
    }
}
