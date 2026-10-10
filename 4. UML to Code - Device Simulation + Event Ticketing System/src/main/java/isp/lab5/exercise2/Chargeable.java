package isp.lab5.exercise2;

/**
 * @author Radu Miron
 */
public interface Chargeable {

    int getBatteryLevel();
    void charge(int durationInMinutes);
}