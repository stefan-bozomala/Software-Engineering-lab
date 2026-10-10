package isp.lab8.airways;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise {
    private static final AirplaneRouteManager manager = new AirplaneRouteManager();

    public static void main(String[] args) {
        interactiveMenu();
    }

    private static void interactiveMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("\n=== AIRPLANE ROUTE MANAGER MENU ===\n");

        while (running) {
            System.out.println("Options:");
            System.out.println("1. Create a new route");
            System.out.println("2. Add waypoint to route");
            System.out.println("3. Load and display route");
            System.out.println("4. Calculate route distance");
            System.out.println("5. List all routes");
            System.out.println("6. Delete route");
            System.out.println("7. Exit");
            System.out.print("\nSelect option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    createNewRoute(scanner);
                    break;
                case "2":
                    addWaypointToRoute(scanner);
                    break;
                case "3":
                    loadAndDisplayRoute(scanner);
                    break;
                case "4":
                    calculateRouteDistance(scanner);
                    break;
                case "5":
                    listAllRoutes();
                    break;
                case "6":
                    deleteRoute(scanner);
                    break;
                case "7":
                    running = false;
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.\n");
            }
        }
        scanner.close();
    }

    private static void createNewRoute(Scanner scanner) {
        System.out.print("Enter route name: ");
        String routeName = scanner.nextLine().trim();

        AirplaneRoute route = new AirplaneRoute();
        route.setName(routeName);
        route.setWaypoints(new ArrayList<>());

        try {
            manager.createRoute(route);
            System.out.println("Route '" + routeName + "' created.\n");
        } catch (Exception e) {
            System.out.println("Error creating route: " + e.getMessage() + "\n");
        }
    }

    private static void addWaypointToRoute(Scanner scanner) {
        System.out.print("Enter route name: ");
        String routeName = scanner.nextLine().trim();

        try {
            AirplaneRoute route = manager.loadRoute(routeName);
            if (route == null) {
                System.out.println("Route not found.\n");
                return;
            }

            System.out.print("Enter waypoint name: ");
            String wpName = scanner.nextLine().trim();
            System.out.print("Enter latitude: ");
            double latitude = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Enter longitude: ");
            double longitude = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Enter altitude (m): ");
            int altitude = Integer.parseInt(scanner.nextLine().trim());

            Waypoint waypoint = new Waypoint(route.getWaypoints().size() + 1, wpName, latitude, longitude, altitude);
            route.getWaypoints().add(waypoint);

            manager.createRoute(route);
            System.out.println("Waypoint added and route updated.\n");
        } catch (Exception e) {
            System.out.println("Error adding waypoint: " + e.getMessage() + "\n");
        }
    }

    private static void loadAndDisplayRoute(Scanner scanner) {
        System.out.print("Enter route name: ");
        String routeName = scanner.nextLine().trim();

        try {
            AirplaneRoute route = manager.loadRoute(routeName);
            if (route == null) {
                System.out.println("Route not found.\n");
                return;
            }

            System.out.println("\nRoute: " + route.getName());
            System.out.println("Waypoints:");
            for (Waypoint wp : route.getWaypoints()) {
                System.out.println("  " + wp.getIndex() + ". " + wp.getName() + 
                        " (Lat: " + wp.getLatitude() + ", Lon: " + wp.getLongitude() + 
                        ", Alt: " + wp.getAltitude() + "m)");
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Error loading route: " + e.getMessage() + "\n");
        }
    }

    private static void calculateRouteDistance(Scanner scanner) {
        System.out.print("Enter route name: ");
        String routeName = scanner.nextLine().trim();

        try {
            AirplaneRoute route = manager.loadRoute(routeName);
            if (route == null) {
                System.out.println("Route not found.\n");
                return;
            }

            double distance = manager.calculateDistance(route);
            System.out.println("Total distance for route '" + routeName + "': " + 
                    String.format("%.2f", distance) + " km\n");
        } catch (Exception e) {
            System.out.println("Error calculating distance: " + e.getMessage() + "\n");
        }
    }

    private static void listAllRoutes() {
        List<String> routes = manager.listRoutes();
        if (routes.isEmpty()) {
            System.out.println("No routes available.\n");
        } else {
            System.out.println("Available routes:");
            for (String routeName : routes) {
                System.out.println("  - " + routeName);
            }
            System.out.println();
        }
    }

    private static void deleteRoute(Scanner scanner) {
        System.out.print("Enter route name to delete: ");
        String routeName = scanner.nextLine().trim();

        manager.deleteRoute(routeName);
        System.out.println("Route deleted.\n");
    }
}