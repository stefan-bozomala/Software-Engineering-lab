package isp.lab6.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
            VehicleRegistrySystem registry = new VehicleRegistrySystem();

            Vehicle v1 = new Vehicle("VIN123", "CJ01ABC", "BMW", "X5", 2020);
            Vehicle v2 = new Vehicle("VIN456", "CJ02DEF", "Audi", "A4", 2018);
            Vehicle v3 = new Vehicle("VIN123", "CJ03GHI", "Mercedes", "C200", 2022);

            System.out.println("Add v1: " + registry.addVehicle(v1));
            System.out.println("Add v2: " + registry.addVehicle(v2));
            System.out.println("Add v3 (duplicate VIN): " + registry.addVehicle(v3));

            System.out.println("\nVehicles in registry:");
            registry.displayVehicles();

            System.out.println("\nContains VIN123: " + registry.containsVehicle("VIN123"));
            System.out.println("Contains VIN999: " + registry.containsVehicle("VIN999"));

            System.out.println("\nRemove VIN123: " + registry.removeVehicleByVin("VIN123"));

            System.out.println("\nVehicles after removal:");
            registry.displayVehicles();
        }
    }