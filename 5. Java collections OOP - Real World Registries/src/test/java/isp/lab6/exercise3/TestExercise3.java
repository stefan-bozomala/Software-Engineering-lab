package isp.lab6.exercise3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestExercise3 {

    private OnlineStore store;
    private LoginSystem loginSystem;
    private Product p1;
    private Product p2;

    @BeforeEach
    public void setUp() {
        store = new OnlineStore();
        loginSystem = new LoginSystem(store);

        p1 = new Product("Apple", 1.50);
        p2 = new Product("Banana", 0.75);
        store.addProduct(p1);
        store.addProduct(p2);
    }

    @Test
    public void testUserRegistrationAndLogin() {
        loginSystem.register("testuser", "pass123");

        assertFalse(loginSystem.login("testuser", "wrongpass"), "Login should fail with wrong password");
        assertTrue(loginSystem.login("testuser", "pass123"), "Login should succeed with correct credentials");
    }

    @Test
    public void testAddToCartAndCheckout() {
        loginSystem.register("buyer", "pass");
        loginSystem.login("buyer", "pass");

        store.addToCart("buyer", p1, 2); // $3.00
        store.addToCart("buyer", p2, 4); // $3.00

        String receipt = store.checkout("buyer");

        assertTrue(receipt.contains("Apple x2"));
        assertTrue(receipt.contains("Banana x4"));
        assertTrue(receipt.contains("Total: $6.00"));

        String secondCheckout = store.checkout("buyer");
        assertEquals("Your cart is empty.", secondCheckout);
    }

    @Test
    public void testProductSorting() {
        List<Product> sorted = store.getProductsSorted(Comparator.comparingDouble(p -> p.price));

        assertEquals("Banana", sorted.get(0).name, "Banana should be first (cheaper)");
        assertEquals("Apple", sorted.get(1).name, "Apple should be second");
    }

    @Test
    public void testLogoutRemovesSession() {
        loginSystem.register("user", "pass");
        loginSystem.login("user", "pass");

        assertTrue(loginSystem.logout("user"));

        assertEquals("Checkout failed: No active session.", store.checkout("user"));
    }
}