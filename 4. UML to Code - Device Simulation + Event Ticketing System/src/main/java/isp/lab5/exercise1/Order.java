package isp.lab5.exercise1;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private String orderId;
    private LocalDateTime date;
    private double totalPrice;
    private ArrayList<Product> products = new ArrayList<Product>();
    private Customer customer;

    public Order(String orderId, LocalDateTime date, double totalPrice, Customer customer, ArrayList<Product> products) {
        this.orderId = orderId;
        this.date = date;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.products = products;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", date=" + date +
                ", totalPrice=" + totalPrice +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}