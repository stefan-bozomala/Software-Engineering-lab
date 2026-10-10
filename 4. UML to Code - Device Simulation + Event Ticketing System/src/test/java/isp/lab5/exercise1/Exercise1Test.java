package isp.lab5.exercise1;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * @author Radu Miron
 * @version 1
 */
public class Exercise1Test {

    @Test
    public void testProduct(){
        ArrayList<Product> products = new ArrayList<Product>();
        Product product = new Product("123a",ProductCategory.FASHION,30.5,"Bluza");
        products.add(product);

        Address address = new Address("CaleaTurzii","Cluuj");
        Customer customer = new Customer("123a", address, "0757", "Liviu");
        Order order = new Order("123a", LocalDateTime.of(2026, 3,30,9,30),12.5, customer, products);

        assertEquals("Product{productId='123a', name='Bluza', price=30.5, productCategory=Fashion}", product.toString());
        assertEquals("Customer{customerId='123a', name='Liviu', phone='0757', address=Address{street='CaleaTurzii', city='Cluuj'}}", customer.toString());
        assertEquals("Order{orderId='123a', date=2026-03-30T09:30, totalPrice=12.5, products=[Product{productId='123a', name='Bluza', price=30.5, productCategory=Fashion}], customer=Customer{customerId='123a', name='Liviu', phone='0757', address=Address{street='CaleaTurzii', city='Cluuj'}}}", order.toString());
        assertEquals("Address{street='CaleaTurzii', city='Cluuj'}", address.toString());
    }

}
