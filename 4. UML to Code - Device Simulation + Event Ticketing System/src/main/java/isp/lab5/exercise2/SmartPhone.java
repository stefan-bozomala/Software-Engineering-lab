package isp.lab5.exercise2;

public class SmartPhone implements Chargeable {

    private int batteryLevel;
    private int chargeRate = 3;

    public int getBatteryLevel(){
        return batteryLevel;
    };

    public void charge(int durationInMinutes){
        if (batteryLevel<100) batteryLevel = batteryLevel + chargeRate * durationInMinutes;
        else System.out.println("SmartPhone battery fully charged");
    };

    public SmartPhone(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public int getChargeRate() {
        return chargeRate;
    }

    public void setChargeRate(int chargeRate) {
        this.chargeRate = chargeRate;
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "batteryLevel=" + batteryLevel +
                ", chargeRate=" + chargeRate +
                '}';
    }
}
