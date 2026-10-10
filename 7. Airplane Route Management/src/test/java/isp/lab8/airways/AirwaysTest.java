package isp.lab8.airways;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AirwaysTest {
    private AirplaneRouteManager manager;
    private static final String ROUTES_FOLDER = "routes";

    @Before
    public void setUp() {
        manager = new AirplaneRouteManager();
        cleanupTestRoutes();
    }

    @Test
    public void testCreateRoute() throws Exception {
        AirplaneRoute route = new AirplaneRoute();
        route.setName("TestRoute");
        route.setWaypoints(new ArrayList<>());
        route.getWaypoints().add(new Waypoint(1, "Point1", 46.0, 23.0, 1000));
        route.getWaypoints().add(new Waypoint(2, "Point2", 47.0, 24.0, 2000));

        manager.createRoute(route);

        File routeFolder = new File(ROUTES_FOLDER + "/TestRoute");
        assertTrue("Route folder should exist", routeFolder.exists());

        File waypoint1 = new File(routeFolder + "/waypoint_1.json");
        File waypoint2 = new File(routeFolder + "/waypoint_2.json");
        assertTrue("Waypoint 1 file should exist", waypoint1.exists());
        assertTrue("Waypoint 2 file should exist", waypoint2.exists());
    }

    @Test
    public void testLoadRoute() throws Exception {
        AirplaneRoute route = new AirplaneRoute();
        route.setName("TestRoute");
        route.setWaypoints(new ArrayList<>());
        route.getWaypoints().add(new Waypoint(1, "Point1", 46.0, 23.0, 1000));
        route.getWaypoints().add(new Waypoint(2, "Point2", 47.0, 24.0, 2000));

        manager.createRoute(route);

        AirplaneRoute loadedRoute = manager.loadRoute("TestRoute");
        assertNotNull("Loaded route should not be null", loadedRoute);
        assertEquals("Route name should match", "TestRoute", loadedRoute.getName());
        assertEquals("Should have 2 waypoints", 2, loadedRoute.getWaypoints().size());
        assertEquals("First waypoint name should match", "Point1", loadedRoute.getWaypoints().get(0).getName());
    }

    @Test
    public void testCalculateDistance() {
        AirplaneRoute route = new AirplaneRoute();
        route.setName("TestRoute");
        route.setWaypoints(new ArrayList<>());
        route.getWaypoints().add(new Waypoint(1, "LRCL", 46.7852, 23.6862, 415));
        route.getWaypoints().add(new Waypoint(2, "LROP", 44.5711, 26.0858, 106));

        double distance = manager.calculateDistance(route);
        assertTrue("Distance should be positive", distance > 0);
        assertTrue("Distance should be around 300-350 km", distance > 250 && distance < 400);
    }

    @Test
    public void testDeleteRoute() throws Exception {
        AirplaneRoute route = new AirplaneRoute();
        route.setName("TestRoute");
        route.setWaypoints(new ArrayList<>());
        route.getWaypoints().add(new Waypoint(1, "Point1", 46.0, 23.0, 1000));

        manager.createRoute(route);

        File routeFolder = new File(ROUTES_FOLDER + "/TestRoute");
        assertTrue("Route folder should exist", routeFolder.exists());

        manager.deleteRoute("TestRoute");

        assertFalse("Route folder should be deleted", routeFolder.exists());
    }

    @Test
    public void testListRoutes() throws Exception {
        AirplaneRoute route1 = new AirplaneRoute();
        route1.setName("Route1");
        route1.setWaypoints(new ArrayList<>());
        route1.getWaypoints().add(new Waypoint(1, "Point1", 46.0, 23.0, 1000));

        AirplaneRoute route2 = new AirplaneRoute();
        route2.setName("Route2");
        route2.setWaypoints(new ArrayList<>());
        route2.getWaypoints().add(new Waypoint(1, "Point1", 46.0, 23.0, 1000));

        manager.createRoute(route1);
        manager.createRoute(route2);

        List<String> routes = manager.listRoutes();
        assertTrue("Should contain Route1", routes.contains("Route1"));
        assertTrue("Should contain Route2", routes.contains("Route2"));
        assertTrue("Should have at least 2 routes", routes.size() >= 2);
    }

    @Test
    public void testCalculateTotalDistanceLRCLLROP() {
        AirplaneRoute route = new AirplaneRoute();
        route.setName("LRCL-LROP");
        route.setWaypoints(new ArrayList<>());

        route.getWaypoints().add(new Waypoint(1, "LRCL", 46.7852, 23.6862, 415));
        route.getWaypoints().add(new Waypoint(2, "TASOD", 47.0548, 23.9212, 10460));
        route.getWaypoints().add(new Waypoint(3, "SOPAV", 46.9804, 24.7365, 10900));
        route.getWaypoints().add(new Waypoint(4, "BIRGU", 45.9467, 26.0217, 10200));
        route.getWaypoints().add(new Waypoint(5, "LROP", 44.5711, 26.0858, 106));

        double distance = route.calculateTotalDistance();
        assertTrue("Distance should be positive", distance > 0);
        System.out.println("LRCL-LROP total distance: " + distance + " km");
    }

    @Test
    public void testEmptyRoute() {
        AirplaneRoute route = new AirplaneRoute();
        route.setName("EmptyRoute");
        route.setWaypoints(new ArrayList<>());

        double distance = route.calculateTotalDistance();
        assertEquals("Empty route distance should be 0", 0.0, distance, 0.01);
    }

    @Test
    public void testSingleWaypointRoute() {
        AirplaneRoute route = new AirplaneRoute();
        route.setName("SingleRoute");
        route.setWaypoints(new ArrayList<>());
        route.getWaypoints().add(new Waypoint(1, "Point1", 46.0, 23.0, 1000));

        double distance = route.calculateTotalDistance();
        assertEquals("Single waypoint route distance should be 0", 0.0, distance, 0.01);
    }

    private void cleanupTestRoutes() {
        File routesDir = new File(ROUTES_FOLDER);
        if (routesDir.exists()) {
            File[] subdirs = routesDir.listFiles(File::isDirectory);
            if (subdirs != null) {
                for (File dir : subdirs) {
                    File[] files = dir.listFiles();
                    if (files != null) {
                        for (File file : files) {
                            file.delete();
                        }
                    }
                    dir.delete();
                }
            }
        }
    }
}

