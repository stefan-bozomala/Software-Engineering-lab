package isp.lab5.exercise4;

public class OrganizerApp {
    private TicketsManager manager;

    public OrganizerApp(TicketsManager manager) {
        this.manager = manager;
    }

    public void checkIn(Ticket ticket) {
        if (manager.validateTicket(ticket)) {
            System.out.println("Check in - ticket valid");
        } else {
            System.out.println("Check in - ticket invalid");
        }
    }
}
