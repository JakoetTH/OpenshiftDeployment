package Airline.conf;

import Airline.domain.Ticket;

public class TicketFactory {

    public static Ticket createTicket(String ID,
                                    float price,
                                    String ticketClass,
                                    String clerkID,
                                    String passengerID,
                                    String flightID)
    {
        Ticket ticket = new Ticket
                .Builder(ID)
                .price(price)
                .ticketClass(ticketClass)
                .clerkID(clerkID)
                .passengerID(passengerID)
                .flightID(flightID)
                .build();
        return ticket;
    }
}
