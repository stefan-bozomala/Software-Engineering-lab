package isp.lab5.exercise4;

public abstract class AbstractTicketsManager {

    public Ticket generateTicket(Category category, int price) {
        return new Ticket(category, price);
    }

    public abstract boolean validateTicket(Ticket ticket);
}
