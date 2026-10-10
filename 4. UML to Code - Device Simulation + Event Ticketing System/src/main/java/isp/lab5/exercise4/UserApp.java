package isp.lab5.exercise4;

public class UserApp {
    private TicketsManager manager;

    public UserApp(TicketsManager manager) {
        this.manager = manager;
    }

    public Ticket buyTicket(Category category, int price) {
        Ticket t = manager.generateTicket(category, price);
        System.out.println("Ticket bought");
        return t;
    }

    public String viewTicket(Ticket ticket) {
        System.out.println(ticket.toString());
        return ticket.toString();
    }
}