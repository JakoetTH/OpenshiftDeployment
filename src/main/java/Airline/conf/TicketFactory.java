package Airline.conf;

import Airline.domain.Ticket;

public class TicketFactory {

    public static Ticket createTicket(String ID,
                                    float price,
                                    String ticketClass)
    {
        Ticket ticket = new Ticket
                .Builder(ID)
                .price(price)
                .ticketClass(ticketClass)
                .build();
        return ticket;
    }
}
