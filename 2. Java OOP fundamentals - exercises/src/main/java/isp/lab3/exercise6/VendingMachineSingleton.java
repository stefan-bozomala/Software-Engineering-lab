package isp.lab3.exercise6;

import isp.lab3.exercise5.Product;

import java.util.Scanner;

public final class VendingMachineSingleton {
    private static volatile VendingMachineSingleton instance;

    private isp.lab3.exercise5.Product[] products = {
            new isp.lab3.exercise5.Product(0, "water", 5),
            new isp.lab3.exercise5.Product(1, "biscuits", 5),
            new Product(2, "chocolate", 7)
    };
    private int credit = 0;

    private VendingMachineSingleton() {}

    public static VendingMachineSingleton getInstance() {
        if (instance == null) {
            synchronized (VendingMachineSingleton.class) {
                if (instance == null) {
                    instance = new VendingMachineSingleton();
                }
            }
        }
        return instance;
    }

    public void displayProducts() {
        System.out.println("Available Products:");
        System.out.println(" Product water id 0 price 5");
        System.out.println(" Product biscuits id 1 price 5");
        System.out.println(" Product chocolate id 2 price 7");
    }

    public void insertCoin(int c) {
        credit = credit + c;
        System.out.println("Credit increased by " + c);
    }

    public String selectProduct(int i) { // 2
        if (i >= 0 && i < products.length) {
            if (credit >= products[i].getPrice()) {
                credit = credit - products[i].getPrice();
                return products[i].getName();
            } else {
                return "Add more coins";
            }
        } else {
            return "Wrong id";
        }
    }

    public void displayCredit() {
        System.out.println("Credit = " + credit);
    }

    public void userMenu() {
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        while (option != 4) {
            System.out.println("\nPress 0 for displayProducts()\nPress 1 for insertCoin()\nPress 2 for selectProduct()\nPress 3 for displayCredit()\nPress 4 to close");
            option = scanner.nextInt();
            if (option == 0) displayProducts();
            else if (option == 1) {
                System.out.print("Coins: ");
                insertCoin(scanner.nextInt());
            } else if (option == 2) {
                System.out.print("ID: ");
                System.out.println(" Selected " + selectProduct(scanner.nextInt()));
            } else if (option == 3) displayCredit();
        }
    }
}