package edu.tucn.aut.isp.lab4.exercise4;

import java.time.LocalTime;

public class Exercise4 {
    public static void main(String[] args) {

        AquariumController aquariumController = new AquariumController("bosch","1000",LocalTime.of(8,0,0),new FishFeeder("bosch","1000"), new Lights(), LocalTime.of(8,0,0), LocalTime.of(15,0,0));
        aquariumController.getFishFeeder().fillUp();

        aquariumController.setCurrentTime(LocalTime.of(7,0,0));
        aquariumController.setCurrentTime(LocalTime.of(8,0,0));
    }
}
