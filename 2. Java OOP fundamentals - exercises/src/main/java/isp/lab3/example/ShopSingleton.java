package isp.lab3.example;

/**
 * This class has a singleton implementation. // sablon de implementare
 *
 * @author Radu Miron
 * @version 1
 */
public class ShopSingleton {
    private static final ShopSingleton INSTANCE =
            new ShopSingleton("Butique", 10);
    private String name;
    private int numOfEmployees;

    private ShopSingleton(String name, int numOfEmployees) { // constructor privat - fara constructor default
        this.name = name;
        this.numOfEmployees = numOfEmployees;
    }

    public static ShopSingleton getInstance() {
        return INSTANCE;
    }

    @Override
    public String toString() {
        return "ShopSingleton{" +
                "name='" + name + '\'' +
                ", numOfEmployees=" + numOfEmployees +
                '}';
    }
}
