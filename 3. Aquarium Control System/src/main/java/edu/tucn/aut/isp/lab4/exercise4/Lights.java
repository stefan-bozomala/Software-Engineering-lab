package edu.tucn.aut.isp.lab4.exercise4;

public class Lights {
    private boolean isOn=false;

    public void turnOn(){
        isOn = true;
    }

    public void turnOff(){
        isOn=false;
    }

    public boolean getOn() {
        return isOn;
    }
    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public String toString() {
        return "Lights{" +
                "isOn=" + isOn +
                '}';
    }
}
