package edu.tucn.aut.isp.lab4.exercise6;

public class FishFeeder {

    private String manufacturer;
    private String model;
    private int meals=0;

    public void feed(){
        if (meals>=1) {
            meals--;
            System.out.println("Meals decreased by 1 food");
        }
        else System.out.println("Fill the Feeder");
    }

    public void fillUp(){
        if (meals == 14){
            System.out.println("Feeder allready full");
        }
        else {
            meals = 14;
            System.out.println("Feeder filled with 14 food");
        }
    }

    public FishFeeder(String manufacturer, String model){
        System.out.println("Fish Feeder added");
        this.manufacturer=manufacturer;
        this.model=model;
    }

    @Override
    public String toString() {
        return "FishFeeder{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", meals=" + meals +
                '}';
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMeals() {
        return meals;
    }

    public void setMeals(int meals) {
        this.meals = meals;
    }
}
