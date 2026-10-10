package isp.lab5.exercise2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise2Test {

    @Test
    public void testLaptopCharging() {
        Laptop laptop = new Laptop(20);
        laptop.charge(30);
        assertEquals(50, laptop.getBatteryLevel());
    }

    @Test
    public void testSmartPhoneCharging() {
        // SmartPhone: Start 60%, Rate 3%/min. Charge 5 min -> Expect 75%
        SmartPhone smartPhone = new SmartPhone(60);
        smartPhone.charge(5);
        assertEquals(75, smartPhone.getBatteryLevel());
    }

    @Test
    public void testSmartWatchChargingAndLimit() {
        SmartWatch smartWatch = new SmartWatch(80);

        smartWatch.charge(10);
        assertEquals(100, smartWatch.getBatteryLevel());
    }
}
