package isp.lab10.racedemo;

import isp.lab10.ui.CarPanel;

public class CarThread extends Thread {
    private String name;
    private int distance = 0;
    private CarPanel carPanel;
    private TimerThread timerThread;

    public CarThread(String name, CarPanel carPanel, TimerThread timerThread) {
        //set thread name;
        setName(name);
        this.name = name;
        this.carPanel = carPanel;
        this.timerThread = timerThread;
    }

    public void run() {
        while (distance < 400) {
            // simulate the car moving at a random speed
            int speed = (int) (Math.random() * 10) + 1;
            distance += speed;

            carPanel.updateCarPosition(name, distance);

            try {
                // pause for a moment to simulate the passage of time
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long raceTime = timerThread.getTime();
        carPanel.carFinished(name, raceTime);
    }
}
