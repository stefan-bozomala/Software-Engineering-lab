package isp.lab3.exercise3;

public class MainOfExercise3 {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Dacia", "Logan", 150, Vehicle.FuelType.B);
        Vehicle vehicle2 = new Vehicle("Dacia", "1300", 144, Vehicle.FuelType.B );

        System.out.println( vehicle1.getModel() + " " + vehicle1.getType() + " " + vehicle1.getSpeed() + " " + vehicle1.getFuelType());
        System.out.println(vehicle1.toString());
        System.out.println( vehicle2.getModel() + " " + vehicle2.getType() + " " + vehicle2.getSpeed() + " " + vehicle2.getFuelType());
        System.out.println(vehicle2.toString());

        System.out.println(vehicle1.equals(vehicle2));

        Vehicle.countVehicles();
    }
}
