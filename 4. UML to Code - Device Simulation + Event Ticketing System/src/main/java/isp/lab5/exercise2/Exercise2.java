package isp.lab5.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        Laptop laptop = new Laptop(20);
        laptop.charge(30);
        System.out.println(laptop.getBatteryLevel());

        SmartPhone smartPhone = new SmartPhone(60);
        smartPhone.charge(5);
        System.out.println(smartPhone.getBatteryLevel());

        SmartWatch smartWatch = new SmartWatch(80);
        smartWatch.charge(10);
        System.out.println(smartWatch.getBatteryLevel());
        smartWatch.charge(10);
        System.out.println(smartWatch.getBatteryLevel());
    }
}