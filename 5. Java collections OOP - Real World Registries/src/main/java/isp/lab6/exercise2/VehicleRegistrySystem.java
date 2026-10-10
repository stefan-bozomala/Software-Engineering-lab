package isp.lab6.exercise2;

import java.util.HashSet;
import java.util.Set;

public class VehicleRegistrySystem {
    private Set<Vehicle> vehicles = new HashSet<>();

    public boolean addVehicle(Vehicle vehicle) {
        return vehicles.add(vehicle);
    }

    public boolean removeVehicleByVin(String vin) {
        return vehicles.removeIf(v -> v.getVin().equals(vin));
    }

    public boolean containsVehicle(String vin) {
        return vehicles.stream().anyMatch(v -> v.getVin().equals(vin));
    }

    public void displayVehicles() {
        vehicles.forEach(System.out::println);
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }
}
