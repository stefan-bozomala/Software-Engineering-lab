package edu.tucn.aut.isp.lab4.exercise1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AquariumControllerTest {

    @Test
    void dummyTestNPE(){
        Assertions.assertThrows(NullPointerException.class, () -> {Integer nullInt = null; nullInt.toString();});
    }

    @Test
    void testTime(){
        AquariumController ac = new AquariumController("Bosch","B1");
        ac.setCurrentTime(LocalTime.of(10,0,0));
        assertEquals("AquariumController{manufacturer='Bosch', model='B1', currentTime=10:00}", ac.toString());
    }
}