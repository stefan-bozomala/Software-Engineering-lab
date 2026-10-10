package edu.tucn.aut.isp.lab4.exercise5;

import java.time.LocalTime;

public class Exercise5 {
    public static void main(String[] args) {
        AquariumController aquariumController = new AquariumController("bosch","1", LocalTime.of(8,0,0), new FishFeeder("bosch","1"),26, 15);

        aquariumController.checkTemperature(); //20
        aquariumController.checkWaterLevel(); //10
        System.out.println();

        aquariumController.getTemperatureSensor().setValue(26);
        aquariumController.checkTemperature();
        aquariumController.getLevelSensor().setValue(15);
        aquariumController.checkWaterLevel();
    }
}
