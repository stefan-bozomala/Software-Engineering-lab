package isp.lab3.exercise3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VehicleTest {

    Vehicle vehicle1 = new Vehicle("Dacia", "Logan", 150, Vehicle.FuelType.B);
    @Test
    public void testToString() {
        assertEquals("Dacia (Logan) speed 150 fuel type B", vehicle1.toString());
    }
}