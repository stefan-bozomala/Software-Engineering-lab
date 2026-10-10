package isp.lab6.exercise3;

import java.util.*;

public class OnlineStore {
    private List<Product> products;
    private Map<String, ActiveSession> sessions;

    public OnlineStore() {
        this.products = new ArrayList<>();
        this.sessions = new HashMap<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getProductsSorted(Comparator<Product> sortCriteria) {
        List<Product> sortedList = new ArrayList<>(products);
        sortedList.sort(sortCriteria);
        return sortedList;
    }

    void addSession(String username) {
        sessions.put(username, new ActiveSession(username));
    }

    void removeSession(String username) {
        sessions.remove(username);
    }

    public void addToCart(String username, Product product, int quantity) {
        ActiveSession session = sessions.get(username);
        if (session != null) {
            session.addToCart(product, quantity);
        } else {
            System.out.println("Error: No active session found for user.");
        }
    }

    public String checkout(String username) {
        ActiveSession session = sessions.get(username);
        if (session == null) return "Checkout failed: No active session.";

        Map<Product, Integer> cart = session.getShoppingCart();
        if (cart.isEmpty()) return "Your cart is empty.";

        double total = 0.0;
        StringBuilder receipt = new StringBuilder("--- Receipt for " + username + " ---\n");

        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            double subtotal = p.price * qty;
            total += subtotal;
            receipt.append(p.name).append(" x").append(qty).append("\n");
        }

        receipt.append("------------------------\n");
        receipt.append(String.format(java.util.Locale.US, "Total: $%.2f", total));

        session.clearCart();
        return receipt.toString();
    }
}
