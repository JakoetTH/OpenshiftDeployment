package Airline.conf;

import Airline.domain.Clerk;
import Airline.domain.Ticket;
import java.util.List;

public class ClerkFactory {

    public static Clerk createClerk(String firstName,
                                            String lastName,
                                            String address,
                                            String contact,
                                            String position,
                                            List<Ticket> tickets)
    {
        Clerk clerk = new Clerk
                .Builder(firstName)
                .lastName(lastName)
                .address(address)
                .contact(contact)
                .position(position)
                .tickets(tickets)
                .build();
        return clerk;
    }
}
