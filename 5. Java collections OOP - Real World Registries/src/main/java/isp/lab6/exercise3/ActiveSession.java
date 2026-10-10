package isp.lab6.exercise3;

import java.util.HashMap;
import java.util.Map;

public class ActiveSession {
    private String username;
    private Map<Product, Integer> shoppingCart;

    public ActiveSession(String username) {
        this.username = username;
        this.shoppingCart = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public Map<Product, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public void addToCart(Product product, int quantity) {
        if (quantity <= 0) return;
        shoppingCart.put(product, shoppingCart.getOrDefault(product, 0) + quantity);
    }

    public void clearCart() {
        shoppingCart.clear();
    }
}
