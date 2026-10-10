package isp.lab10.runner;

import isp.lab10.racedemo.CarThread;
import isp.lab10.racedemo.SemaphoreThread;
import isp.lab10.racedemo.TimerThread;
import isp.lab10.ui.CarPanel;
import isp.lab10.ui.SemaphorePanel;
import isp.lab10.utils.PlaySound;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Race started");

        startSemaphore();
        startRace();

        System.out.println("Race ended");
    }

    private static void startRace() {

        JFrame frame = new JFrame("Car Race");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CarPanel carPanel = new CarPanel();

        frame.getContentPane().add(carPanel);
        frame.pack();
        frame.setSize(500, 300);
        frame.setVisible(true);

        TimerThread timerThread = new TimerThread();
        PlaySound playSound = new PlaySound();

        CarThread car1 = new CarThread("Red car", carPanel, timerThread);
        CarThread car2 = new CarThread("Blue car", carPanel, timerThread);
        CarThread car3 = new CarThread("Green car", carPanel, timerThread);
        CarThread car4 = new CarThread("Yellow car", carPanel, timerThread);

        playSound.playSound();
        timerThread.start();

        car1.start();
        car2.start();
        car3.start();
        car4.start();

        try {
            car1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            car2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            car3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            car4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timerThread.stopTimer();
        try {
            timerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Race lasted: " + timerThread.getTime() + " ms");
        playSound.stopSound();
    }

    private static void startSemaphore() {
        JFrame frame = new JFrame("Semaphore");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SemaphorePanel semaphorePanel = new SemaphorePanel();

        frame.getContentPane().add(semaphorePanel);
        frame.pack();
        frame.setVisible(true);

        SemaphoreThread semaphoreThread = new SemaphoreThread(semaphorePanel);
        semaphoreThread.start();

        try {
            semaphoreThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
