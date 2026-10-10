package isp.lab5.exercise4;

public class Ticket {
    private Category category;
    private int price;
    private boolean isValid = true;

    public Ticket(Category category, int price) {
        this.category = category;
        this.price = price;
    }

    public void setValid(boolean valid) { isValid = valid; }
    public boolean isValid() { return isValid; }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "category=" + category +
                ", price=" + price +
                ", isValid=" + isValid +
                '}';
    }
}
