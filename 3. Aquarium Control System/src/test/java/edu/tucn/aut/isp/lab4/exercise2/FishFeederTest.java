package edu.tucn.aut.isp.lab4.exercise2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FishFeederTest {

    @Test
    void fillUp(){
        FishFeeder fishFeeder = new FishFeeder("Bosch","feeder1000");
        fishFeeder.fillUp();
        assertEquals(14, fishFeeder.getMeals());
    }

    @Test
    void feed(){
        FishFeeder fishFeeder = new FishFeeder("Bosch","feeder1000");
        fishFeeder.fillUp();
        fishFeeder.feed();
        assertEquals(13, fishFeeder.getMeals());
    }
}
