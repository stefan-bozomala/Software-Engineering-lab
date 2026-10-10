package edu.tucn.aut.isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        FishFeeder fishFeeder = new FishFeeder("Bosch", "Feeder1000");
        fishFeeder.fillUp();
        System.out.println(fishFeeder);
        fishFeeder.fillUp();

        fishFeeder.feed();
        System.out.println(fishFeeder);
    }
}
