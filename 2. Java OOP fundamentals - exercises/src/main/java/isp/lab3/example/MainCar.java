package isp.lab3.example;

public class MainCar {
    public static void main(String[] args) {
//        Car car1 = new Car();
//        car1.setColor("Blue"); // atribute de instanta - specifice pentru fiecare obiect
//
//        Car car2 = new Car("Red", 120);
//        car2.setColor("Red");
//
//        System.out.println("called with class name " + Car.WHEELS); // valabil pt toate obiectele de tipul clasei car
//        System.out.println("called with car1 " + car1.getColor());
//        System.out.println("called with car2 " + car2.getColor());

        Car car3 = new Car("Red", 140);
        //System.out.println("car3");
        Car car4 = new Car("Red", 120);
        System.out.println(car3.equals(car4));

    }
}
