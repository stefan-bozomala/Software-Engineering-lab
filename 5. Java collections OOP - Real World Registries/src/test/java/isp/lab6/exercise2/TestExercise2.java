package isp.lab6.exercise2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestExercise2 {

    private VehicleRegistrySystem registry;
    private Vehicle v1;
    private Vehicle v2;

    @Before
    public void setup() {
        registry = new VehicleRegistrySystem();

        v1 = new Vehicle("VIN123", "CJ01ABC", "BMW", "X5", 2020);
        v2 = new Vehicle("VIN456", "CJ02DEF", "Audi", "A4", 2018);
    }

    @Test
    public void testAddVehicle() {
        assertTrue(registry.addVehicle(v1));
        assertFalse(registry.addVehicle(v1)); // duplicat VIN
    }

    @Test
    public void testRemoveVehicle() {
        registry.addVehicle(v1);

        assertTrue(registry.removeVehicleByVin("VIN123"));
        assertFalse(registry.containsVehicle("VIN123"));
    }

    @Test
    public void testContainsVehicle() {
        registry.addVehicle(v2);

        assertTrue(registry.containsVehicle("VIN456"));
        assertFalse(registry.containsVehicle("VIN999"));
    }
}
