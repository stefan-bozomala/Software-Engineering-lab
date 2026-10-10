package isp.lab3.exercise5;

import java.util.Scanner;

public class VendingMachine {
    private Product[] products = {
            new Product(0, "water", 5),
            new Product(1, "biscuits", 5),
            new Product(2, "chocolate", 7)
    };
    private int credit = 0;

    public void displayProducts() { // 0
        System.out.println("Available Products:");
        for (int i = 0; i < products.length; i++) {
            System.out.println(" Product " + products[i].getName() + " id " + products[i].getId() + " price " + products[i].getPrice());
        }
    }

    public void insertCoin(int c) { // 1
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

    public void displayCredit() { // 3
        System.out.println("Credit = " + credit);
    }

    public void userMenu() {
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        while (option != 4) {
            System.out.println("\nPress 0 for displayProducts()");
            System.out.println("Press 1 for insertCoin(number of coins)");
            System.out.println("Press 2 for selectProduct(id)");
            System.out.println("Press 3 for displayCredit()");
            System.out.println("Press 4 to close the VendingMachine");

            option = scanner.nextInt();
            if (option == 0) displayProducts();
            else if (option == 1) {
                System.out.println("How much coins do you want to insert?");
                int coins = scanner.nextInt();
                insertCoin(coins);
            } else if (option == 2) {
                System.out.println("Write product id");
                int id = scanner.nextInt();
                System.out.println(" Selected " + selectProduct(id));
            } else if (option == 3) displayCredit();
            else if (option == 4) break;
        }
    }
}