package isp.lab10.ui;


import isp.lab10.racedemo.Car;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarPanel extends JPanel {

    private List<Car> cars = new ArrayList<>();
    private List<Car> standings = new ArrayList<>();

    public CarPanel() {
        Car car1 = new Car("Red car", Color.RED);
        Car car2 = new Car("Blue car", Color.BLUE);
        Car car3 = new Car("Green car", Color.GREEN);
        Car car4 = new Car("Yellow car", Color.YELLOW);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 4; i++) {
            int yPos = 50 + i * 50; // Vertical position of the car
            int xPos = cars.get(i).getCarPosition(); // Horizontal position of the car
            int carSize = 30; // Size of the car

            g.setColor(cars.get(i).getColor());
            g.fillOval(xPos, yPos, carSize, carSize);
            g.setColor(Color.BLACK);
            g.drawString(cars.get(i).getName(), xPos, yPos - 5);
        }
    }

    public void updateCarPosition(String carName, int distance) {
        int carIndex = getCarIndex(carName);
        if (carIndex != -1) {
            cars.get(carIndex).setCarPosition(distance);
            repaint();
        }
    }

    public synchronized void carFinished(String carName, Long time) {
        int carIndex = getCarIndex(carName);
        if (carIndex != -1) {
            Car car = cars.get(carIndex);
            if (!car.isFinished()) {
                car.setFinished(true);
                car.setTime(time);
                standings.add(car);
            }
        }

        if (standings.size() == cars.size()) {
            System.out.println("Standings:");
            for (int i = 0; i < standings.size(); i++) {
                Car car = standings.get(i);
                System.out.println((i + 1) + ") " + car.getName() + " - " + car.getTime() + " ms");
            }
        }

        repaint();
    }

    private int getCarIndex(String carName) {
        for (int i = 0; i < 4; i++) {
            if (cars.get(i).getName().equals(carName)) {
                return i;
            }
        }
        return -1;
    }
}