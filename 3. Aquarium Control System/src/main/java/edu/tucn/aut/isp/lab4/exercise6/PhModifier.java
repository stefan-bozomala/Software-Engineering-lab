package edu.tucn.aut.isp.lab4.exercise6;

public class PhModifier extends Actuator {

    public PhModifier(String manufacturer, String model){
        super(manufacturer, model);
    }

    @Override
    public void turnOn(){
        super.turnOn();
        System.out.println("PhModifier adds solution");
    }

    @Override
    public void turnOff(){
        super.turnOff();
        System.out.println("PhModifier off");
    }

}
