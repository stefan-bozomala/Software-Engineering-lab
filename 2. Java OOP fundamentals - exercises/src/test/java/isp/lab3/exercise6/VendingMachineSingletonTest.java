package isp.lab3.exercise6;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class VendingMachineSingletonTest {

    @Test
    public void testInsertCoin() {
        VendingMachineSingleton vendingmachine1 = VendingMachineSingleton.getInstance();

        vendingmachine1.insertCoin(5);
        assertEquals("water", vendingmachine1.selectProduct(0));
    }

    @Test
    public void testSelectProduct() {
        VendingMachineSingleton vendingmachine2 = VendingMachineSingleton.getInstance();

        assertEquals("Add more coins", vendingmachine2.selectProduct(2));
    }

    @Test
    public void testDisplayProductsEasy() {
        VendingMachineSingleton vendingmachine3 = VendingMachineSingleton.getInstance();
        vendingmachine3.displayProducts();
    }
}