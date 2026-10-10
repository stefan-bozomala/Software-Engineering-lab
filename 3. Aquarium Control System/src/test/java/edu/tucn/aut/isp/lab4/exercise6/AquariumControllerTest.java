package edu.tucn.aut.isp.lab4.exercise6;

import edu.tucn.aut.isp.lab4.exercise6.AquariumController;
import edu.tucn.aut.isp.lab4.exercise6.FishFeeder;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AquariumControllerTest {

    AquariumController aquariumController = new AquariumController("bosch", "1", LocalTime.of(8, 0, 0), new FishFeeder("bosch", "1"), 26, 15,7);

    @Test
    void checkPhLevel() {
        aquariumController.getPhSensor().setValue(7);
        aquariumController.checkPhLevel(); //20
        assertEquals(false, aquariumController.getPhModifier().isOn());

        aquariumController.getPhSensor().setValue(5);
        aquariumController.checkPhLevel();
        assertEquals(true, aquariumController.getPhModifier().isOn());
    }
}
