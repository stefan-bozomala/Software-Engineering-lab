package isp.lab5.exercise3;

public abstract class Sensor {

    private String installLocation;
    private String name;
    private String type;

    public abstract double getValue();

    public Sensor(String installLocation, String name) {
        this.installLocation = installLocation;
        this.name = name;
    }

    public String getInstallLocation() {
        return installLocation;
    }

    public void setInstallLocation(String installLocation) {
        this.installLocation = installLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "installLocation='" + installLocation + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
