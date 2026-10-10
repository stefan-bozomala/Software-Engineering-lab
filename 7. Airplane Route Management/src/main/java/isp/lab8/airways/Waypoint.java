package isp.lab8.airways;

import lombok.*;

/**
 * Example waypoint class which can be extended to be used in implementation of the exercise. Add constructor, getters, setters, etc.
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Waypoint {
    private int index;
    private String name;
    private double latitude;
    private double longitude;
    private int altitude;
}
