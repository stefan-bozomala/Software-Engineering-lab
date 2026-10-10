package isp.lab5.exercise4;

public class TicketsManager extends AbstractTicketsManager{

    private PaymentGateway paymentGateway = new PaymentGateway();

    @Override
    public Ticket generateTicket(Category category, int price) {
        paymentGateway.payment();
        return new Ticket(category, price);
    }

    @Override
    public boolean validateTicket(Ticket ticket) {
        if (ticket != null && ticket.isValid()) {
            ticket.setValid(false);
            return true;
        }
        return false;
    }
}