package edu.tucn.aut.isp.lab4.exercise4;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AquariumControllerTest {

    @Test
    void setCurrentTime(){
        AquariumController aquariumController = new AquariumController("bosch","1000",LocalTime.of(8,0,0),new FishFeeder("bosch","1000"), new Lights(), LocalTime.of(8,0,0), LocalTime.of(15,0,0));
        aquariumController.getFishFeeder().fillUp();
        assertEquals(14,aquariumController.getFishFeeder().getMeals());

        aquariumController.setCurrentTime(LocalTime.of(7,0,0));
        assertEquals(false,aquariumController.getLights().getOn());
        assertEquals(14,aquariumController.getFishFeeder().getMeals());

        aquariumController.setCurrentTime(LocalTime.of(8,0,0));
        assertEquals(true,aquariumController.getLights().getOn());
        assertEquals(13,aquariumController.getFishFeeder().getMeals());
    }
}
