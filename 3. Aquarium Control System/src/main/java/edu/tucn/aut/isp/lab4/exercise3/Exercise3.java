package edu.tucn.aut.isp.lab4.exercise3;

import java.time.LocalTime;

public class Exercise3 {
    public static void main(String[] args) {

        FishFeeder fishFeeder = new FishFeeder("Bosch", "feeder1000");
        AquariumController aquariumController = new AquariumController("Bosch","Aquarium1000", fishFeeder);

        aquariumController.setFeedingTime(LocalTime.of(8,0));

        fishFeeder.fillUp();
        aquariumController.setCurrentTime(LocalTime.of(8,0,0));
        System.out.println(aquariumController);
    }
}
