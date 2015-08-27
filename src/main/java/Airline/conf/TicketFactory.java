package Airline.conf;

import Airline.domain.Ticket;

public class TicketFactory {

    public static Ticket createTicket(float price,
                                    String ticketClass)
    {
        Ticket ticket = new Ticket
                .Builder(ticketClass)
                .price(price)
                .build();
        return ticket;
    }
}
