package isp.lab6.exercise3;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private LoginSystem loginSyst;
    private OnlineStore store;
    private Scanner scanner;
    private String currentUser = null;

    public UserInterface() {
        this.store = new OnlineStore();
        this.loginSyst = new LoginSystem(store);
        this.scanner = new Scanner(System.in);

        store.addProduct(new Product("Laptop", 999.99));
        store.addProduct(new Product("Mouse", 25.50));
        store.addProduct(new Product("Keyboard", 45.00));
        store.addProduct(new Product("Monitor", 199.99));
    }

    public void loadInterface() {
        System.out.println("Welcome to the Online Store!");
        while (true) {
            if (currentUser == null) {
                showAuthMenu();
            } else {
                showStoreMenu();
            }
        }
    }

    private void showAuthMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                System.out.print("Username: ");
                String loginUser = scanner.nextLine();
                System.out.print("Password: ");
                String loginPass = scanner.nextLine();
                if (loginSyst.login(loginUser, loginPass)) {
                    currentUser = loginUser;
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Invalid credentials.");
                }
                break;
            case "2":
                System.out.print("Choose Username: ");
                String regUser = scanner.nextLine();
                System.out.print("Choose Password: ");
                String regPass = scanner.nextLine();
                loginSyst.register(regUser, regPass);
                break;
            case "3":
                System.out.println("Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid option.");
        }
    }

    private void showStoreMenu() {
        System.out.println("\n--- Store Menu (" + currentUser + ") ---");
        System.out.println("1. View Products");
        System.out.println("2. View Products (Sorted by Price)");
        System.out.println("3. Add to Cart");
        System.out.println("4. Checkout");
        System.out.println("5. Logout");
        System.out.print("Choose an option: ");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                displayProducts(store.getProducts());
                break;
            case "2":
                displayProducts(store.getProductsSorted(Comparator.comparingDouble(p -> p.price)));
                break;
            case "3":
                System.out.print("Enter product name: ");
                String pName = scanner.nextLine();
                System.out.print("Enter quantity: ");
                try {
                    int qty = Integer.parseInt(scanner.nextLine());
                    Product found = store.getProducts().stream()
                            .filter(p -> p.name.equalsIgnoreCase(pName))
                            .findFirst().orElse(null);

                    if (found != null) {
                        store.addToCart(currentUser, found, qty);
                        System.out.println("Added to cart.");
                    } else {
                        System.out.println("Product not found.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid quantity.");
                }
                break;
            case "4":
                System.out.println(store.checkout(currentUser));
                break;
            case "5":
                loginSyst.logout(currentUser);
                currentUser = null;
                System.out.println("Logged out.");
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void displayProducts(List<Product> products) {
            System.out.println("\n--- Lista de Produse ---");
            if (products.isEmpty()) {
                System.out.println("Nu există produse disponibile în magazin momentan.");
                return;
            }

            for (Product product : products) {
                System.out.println("- " + product.toString());
            }
            System.out.println("------------------------");
        }
    }
