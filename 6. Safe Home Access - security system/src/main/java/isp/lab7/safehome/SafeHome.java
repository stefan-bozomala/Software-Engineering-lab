package isp.lab7.safehome;

import java.util.Scanner;

public class SafeHome {

    public static void main(String[] args) {
        DoorLockController ctrl = new DoorLockController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to SafeHome System!");

        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Admin Mode");
            System.out.println("2. Tenant Mode");
            System.out.println("3. Exit");
            System.out.print("Select user type: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    handleAdminMenu(ctrl, scanner);
                    break;
                case "2":
                    handleTenantMenu(ctrl, scanner);
                    break;
                case "3":
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleAdminMenu(DoorLockController ctrl, Scanner scanner) {
        while (true) {
            System.out.println("\n[ADMIN MENU]");
            System.out.println("1. Add Tenant");
            System.out.println("2. Remove Tenant");
            System.out.println("3. View Access Logs");
            System.out.println("4. Back to Main Menu");
            System.out.print("Option: ");

            String opt = scanner.nextLine();

            try {
                if (opt.equals("1")) {
                    System.out.print("Enter Name: "); String name = scanner.nextLine();
                    System.out.print("Enter PIN: "); String pin = scanner.nextLine();
                    ctrl.addTenant(pin, name);
                    System.out.println("Tenant added successfully.");
                }
                else if (opt.equals("2")) {
                    System.out.print("Enter Name to remove: "); String name = scanner.nextLine();
                    ctrl.removeTenant(name);
                    System.out.println("Tenant removed.");
                }
                else if (opt.equals("3")) {
                    System.out.println("\n--- SYSTEM LOGS ---");
                    if (ctrl.getAccessLogList().isEmpty()) {
                        System.out.println("No logs available.");
                    } else {
                        ctrl.getAccessLogList().forEach(System.out::println);
                    }
                }
                else if (opt.equals("4")) {
                    return;
                }
            } catch (Exception e) {
                System.out.println("ADMIN ERROR: " + e.getMessage());
            }
        }
    }

    private static void handleTenantMenu(DoorLockController ctrl, Scanner scanner) {
        System.out.println("\n[TENANT MODE]");
        System.out.print("Enter PIN to toggle door: ");
        String pin = scanner.nextLine();

        try {
            DoorStatus status = ctrl.enterPin(pin);
            System.out.println("SUCCESS! Door is now: " + status);
        } catch (Exception e) {
            System.out.println("ACCESS DENIED: " + e.getMessage());
        }
    }
}