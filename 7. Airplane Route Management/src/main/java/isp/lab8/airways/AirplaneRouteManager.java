package isp.lab8.airways;

import com.fasterxml.jackson.databind.ObjectMapper;
import examples.files.FilesAndFoldersUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AirplaneRouteManager {
    private static final String ROUTES_FOLDER = "routes";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public AirplaneRouteManager() {
        FilesAndFoldersUtil.createFolder(ROUTES_FOLDER);
    }

    public void createRoute(AirplaneRoute route) throws Exception {
        String routeFolderPath = Paths.get(ROUTES_FOLDER, route.getName()).toString();
        FilesAndFoldersUtil.createFolder(routeFolderPath);

        int index = 1;
        for (Waypoint waypoint : route.getWaypoints()) {
            waypoint.setIndex(index);
            String waypointFile = Paths.get(routeFolderPath, "waypoint_" + index + ".json").toString();
            objectMapper.writeValue(new File(waypointFile), waypoint);
            index++;
        }

        String routeMetaFile = Paths.get(routeFolderPath, "route.json").toString();
        objectMapper.writeValue(new File(routeMetaFile), route);
    }

    public AirplaneRoute loadRoute(String routeName) throws Exception {
        return getRoute(routeName);
    }

    public AirplaneRoute getRoute(String routeName) throws Exception {
        String routeFolderPath = Paths.get(ROUTES_FOLDER, routeName).toString();
        File routeFolder = new File(routeFolderPath);

        if (!routeFolder.exists()) {
            return null;
        }

        AirplaneRoute route = new AirplaneRoute();
        route.setName(routeName);
        route.setWaypoints(new ArrayList<>());

        File[] files = routeFolder.listFiles((dir, name) -> name.startsWith("waypoint_") && name.endsWith(".json"));
        if (files != null) {
            Arrays.sort(files, (f1, f2) -> {
                int num1 = Integer.parseInt(f1.getName().replace("waypoint_", "").replace(".json", ""));
                int num2 = Integer.parseInt(f2.getName().replace("waypoint_", "").replace(".json", ""));
                return Integer.compare(num1, num2);
            });

            for (File waypointFile : files) {
                Waypoint waypoint = objectMapper.readValue(waypointFile, Waypoint.class);
                route.getWaypoints().add(waypoint);
            }
        }

        return route;
    }

    public double calculateDistance(AirplaneRoute route) {
        return route.calculateTotalDistance();
    }

    public void deleteRoute(String routeName) {
        String routeFolderPath = Paths.get(ROUTES_FOLDER, routeName).toString();
        File routeFolder = new File(routeFolderPath);
        if (routeFolder.exists()) {
            File[] files = routeFolder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        file.delete();
                    }
                }
            }
            routeFolder.delete();
        }
    }

    public List<String> listRoutes() {
        List<String> routes = new ArrayList<>();
        File routesFolder = new File(ROUTES_FOLDER);

        if (!routesFolder.exists()) {
            return routes;
        }

        File[] files = routesFolder.listFiles(File::isDirectory);
        if (files != null) {
            for (File file : files) {
                routes.add(file.getName());
            }
        }

        return routes;
    }
}
