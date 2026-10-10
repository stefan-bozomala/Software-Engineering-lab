package isp.lab8.airways;

import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class AirplaneRoute {
    private String name;
    private List<Waypoint> waypoints = new ArrayList<>();

    public double calculateTotalDistance() {
        double totalDistance = 0.0;
        
        for (int i = 0; i < waypoints.size() - 1; i++) {
            Waypoint wp1 = waypoints.get(i);
            Waypoint wp2 = waypoints.get(i + 1);
            
            double distanceBetweenWaypoints = WaypointDistanceCalculator.calculateDistance(wp1.getLatitude(), wp1.getLongitude(), wp2.getLatitude(), wp2.getLongitude());
            totalDistance += distanceBetweenWaypoints;
        }
        
        return totalDistance;
    }
}
