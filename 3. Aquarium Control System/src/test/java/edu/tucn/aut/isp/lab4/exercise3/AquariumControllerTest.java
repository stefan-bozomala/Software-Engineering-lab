package edu.tucn.aut.isp.lab4.exercise3;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AquariumControllerTest {

    @Test
    void setCurrentTime(){
        FishFeeder fishFeeder = new FishFeeder("Bosch", "feeder1000");
        AquariumController aquariumController = new AquariumController("Bosch","Aquarium1000", fishFeeder);

        aquariumController.setFeedingTime(LocalTime.of(8,0));

        fishFeeder.fillUp();
        aquariumController.setCurrentTime(LocalTime.of(8,0,0));
        assertEquals(13,fishFeeder.getMeals());
    }
}
