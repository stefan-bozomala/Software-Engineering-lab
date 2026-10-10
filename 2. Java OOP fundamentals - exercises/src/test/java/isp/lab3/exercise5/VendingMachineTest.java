package isp.lab3.exercise5;

import isp.lab3.exercise5.VendingMachine;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {
    VendingMachine vendingMachine = new VendingMachine();

    @Test
    public void testInsertCoin() {
        VendingMachine vendingMachine1 = new VendingMachine();

        vendingMachine1.insertCoin(5); // inceop cu 0 bani si introduc 5 bani deci suficienti pentru apa de 5 lei
        assertEquals("water", vendingMachine1.selectProduct(0));
    }

    @Test
    public void testSelectProduct() {
        VendingMachine vendingMachine2 = new VendingMachine();
        assertEquals("Add more coins", vendingMachine2.selectProduct(0));
    }

    @Test
    public void testDisplayProductsEasy() {
        VendingMachine vendingmachine3 = new VendingMachine();
        vendingmachine3.displayProducts();
    }
}