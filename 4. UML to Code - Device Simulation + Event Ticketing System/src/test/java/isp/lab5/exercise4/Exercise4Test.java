package isp.lab5.exercise4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise4Test {

    @Test
    public void testBuyTicket() {
        TicketsManager manager = new TicketsManager();
        UserApp userApp = new UserApp(manager);

        Ticket t = userApp.buyTicket(Category.MOVIE, 40);

        assertEquals(40, t.getPrice());
        assertEquals(Category.MOVIE, t.getCategory());

    }

    @Test
    public void testViewTicket() {
        TicketsManager manager = new TicketsManager();
        UserApp userApp = new UserApp(manager);

        Ticket t = userApp.buyTicket(Category.THEATER, 50);

        assertEquals("Ticket{category=Category{displayCategory='Theater'}, price=50, isValid=true}", userApp.viewTicket(t));
    }

    @Test
    public void testCheckIn() {
        TicketsManager manager = new TicketsManager();
        OrganizerApp organizerApp = new OrganizerApp(manager);
        Ticket t = new Ticket(Category.OPERA, 100);

        organizerApp.checkIn(t);

        assertEquals(false, t.isValid());
    }
}