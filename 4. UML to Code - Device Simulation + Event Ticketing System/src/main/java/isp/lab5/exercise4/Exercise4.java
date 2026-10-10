package isp.lab5.exercise4;

public class Exercise4 {
    public static void main(String[] args) {
        TicketsManager ticketsManager = new TicketsManager();
        UserApp userApp = new UserApp(ticketsManager);
        OrganizerApp organizerApp = new OrganizerApp(ticketsManager);

        Ticket ticket = userApp.buyTicket(Category.MOVIE, 40);
        userApp.viewTicket(ticket);

        organizerApp.checkIn(ticket);
        userApp.viewTicket(ticket);

        organizerApp.checkIn(ticket);
        userApp.viewTicket(ticket);
    }
}