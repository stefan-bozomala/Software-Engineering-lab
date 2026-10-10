package isp.lab5.exercise1;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Exercise1 {

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<Product>();
        Product product = new Product("123a",ProductCategory.FASHION,30.50,"Bluza");
        products.add(product);

        Address address = new Address("CaleaTurzii","Cluuj");
        Customer customer = new Customer("123a", address, "0757", "Liviu");
        Order order = new Order("123a", LocalDateTime.of(2026, 3,30,9,30),12.5,customer,products);

        System.out.println(product.toString());
        System.out.println(customer.toString());
        System.out.println(order.toString());
        System.out.println(address.toString());
    }
}
