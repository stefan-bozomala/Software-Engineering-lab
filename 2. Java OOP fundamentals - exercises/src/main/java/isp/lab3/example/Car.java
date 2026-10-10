package isp.lab3.example;

//private, protected, private(default), public
//incapsulare - getter/setter

import java.util.Objects;

public class Car { // template

    private String color; // atribute de instanta - tin de obiecte
    private int speed;
    public static final int WHEELS = 4; //pt toate instantele clasei car

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Car() { // constructor implicit - instantiem clasele - suprascriem - exista doar daca nu e definit niciun alt constructor
        System.out.println("Car created");
    }

    public Car(String color, int speed) {
        this.color = color;
        this.speed = speed;
        System.out.println("Car created with color and speed");
    }

    @Override // metoda e suprascriesa dintr-o superclasa
    public String toString() {
        return "Car (override method) with color " + color + "speed " + speed;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Car that = (Car) obj;
        return speed == that.speed &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, speed);
    }
}