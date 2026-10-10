package isp.lab5.exercise3;

import java.util.ArrayList;

public class MonitoringService {

    private ArrayList<Sensor> sensors = new ArrayList<>();

    public double getAverageTemperatureSensors(){
        int nr = 0;
        double sum = 0;
        for(Sensor sensor : sensors)
        {
            if("temperature".equals(sensor.getType())){
                sum = sum + sensor.getValue();
                nr ++;
            }
        }
        if(nr==0) return 0;
        else return sum/nr;
    }

    public double getAverageAllSensors(){
        int nr=0;
        double sum = 0;
        for (Sensor sensor : sensors) {
            sum = sum + sensor.getValue();
            nr ++;
        }
        if(nr==0) return 0;
        else return sum/nr;
    }

    public MonitoringService(ArrayList<Sensor> sensors) {
        this.sensors = sensors;
    }

    public ArrayList<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(ArrayList<Sensor> sensors) {
        this.sensors = sensors;
    }

    @Override
    public String toString() {
        return "MonitoringService{" +
                "sensors=" + sensors +
                '}';
    }
}