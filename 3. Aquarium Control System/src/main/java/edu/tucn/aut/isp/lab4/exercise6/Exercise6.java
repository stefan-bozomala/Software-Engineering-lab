package edu.tucn.aut.isp.lab4.exercise6;

import edu.tucn.aut.isp.lab4.exercise6.AquariumController;
import edu.tucn.aut.isp.lab4.exercise6.FishFeeder;

import java.time.LocalTime;

public class Exercise6 {
    public static void main(String[] args) {
        AquariumController aquariumController = new AquariumController("bosch","1", LocalTime.of(8,0,0), new FishFeeder("bosch","1"),26, 15,5);
        aquariumController.checkPhLevel();
        System.out.println();

        aquariumController.getPhSensor().setValue(8);
        aquariumController.checkPhLevel();
    }
}